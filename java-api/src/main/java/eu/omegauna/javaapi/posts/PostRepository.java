package eu.omegauna.javaapi.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT Post.id, Post.title, Post.text, User.username FROM Post INNER JOIN User ON Post.author = User WHERE User.username = :#{#username}")
    List<Post> findByUser(@Param("username") String username);

    @Query("SELECT id, title, author FROM Post")
    List<Post> getAll ();
}