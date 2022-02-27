package eu.omegauna.javaapi.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT id, username FROM User WHERE username = :#{#username}")
    List<User> findByUser(@Param("username") String username);

    @Query("SELECT id, username FROM User")
    List<User> getAll ();
}