package eu.omegauna.javaapi.user;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/overview")
    public String overview (Model model) {
        User dazzy = new User();
        dazzy.setUserName("dazzy");
        dazzy.setEmail("anderlecht@belgium.be");
        dazzy.setId(1L);

        User miyo = new User();
        miyo.setUserName("miyo");
        miyo.setEmail("miyo.vandenende@belgium.be");
        miyo.setId(2L);
        userRepository.save(dazzy);
        userRepository.save(miyo);
        model.addAttribute("users", userRepository.findAll());
        return "users/overview";
    }

    public String sortAlphabetically(Model model) {
        model.addAttribute("users", userRepository.findAll(Sort.by("username").ascending()));
        return "users/overview";
    }

    @GetMapping("/users/add")
    public String add(User user) {
        return "clubs/add";
    }

    @PostMapping("/users/add")
    public String add(@Valid User club, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "users/add";
        }
        userRepository.save(club);
        return "redirect:/users/overview";
    }

    @GetMapping("/users/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        try {
            User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("User not found with id" + id));
            model.addAttribute(user);
        }
        catch (IllegalArgumentException exc) {
            model.addAttribute("error", exc.getMessage());
        }
        return "users/update";
    }

    @PostMapping("/users/update/{id}") // TODO PutMapping??
    public String update (@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("user: Update was called with errors, perhaps the user (using id) was not found?");
            user.setId(id);
            model.addAttribute("user", user);
            return "users/update";
        }
        userRepository.save(user);
        return "redirect:/users/overview";
    }

    @PostMapping("/users/delete/{id}")
    public String delete (@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("user: Delete was called with errors, perhaps the user (using id) was not found?");
            model.addAttribute("User", user);
            return "users/delete";
        }
        userRepository.delete(user);
        return "redirect:/users/overview";
    }
}