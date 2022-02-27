package eu.omegauna.javaapi.posts;

import eu.omegauna.javaapi.user.User;
import eu.omegauna.javaapi.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts/overview")
    public String overview (Model model) {
        Post post1 = new Post();
        post1.setTitle("Something happened");
        post1.setText("This is what happened");
        post1.setAuthor(new User());
        post1.setId(1L);

        Post post2 = new Post();
        post2.setTitle("Something happened");
        post2.setText("This is what happened");
        post2.setAuthor(new User());
        post2.setId(2L);
        postRepository.save(post1);
        postRepository.save(post2);
        model.addAttribute("posts", postRepository.findAll());
        return "posts/overview";
    }

    public String sortAlphabetically(Model model) {
        model.addAttribute("users", postRepository.findAll(Sort.by("username").ascending()));
        return "users/overview";
    }

    @GetMapping("/posts/add")
    public String add(Post post) {
        return "posts/add";
    }

    @PostMapping("/posts/add")
    public String add(@Valid Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "users/add";
        }
        postRepository.save(post);
        return "redirect:/posts/overview";
    }

    @GetMapping("/posts/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        try {
            Post post = postRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Post not found with id" + id));
            model.addAttribute(post);
        }
        catch (IllegalArgumentException exc) {
            model.addAttribute("error", exc.getMessage());
        }
        return "posts/update";
    }

    @PostMapping("/posts/update/{id}") // TODO PutMapping??
    public String update (@PathVariable("id") long id, @Valid Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("post: Update was called with errors, perhaps the user (using id) was not found?");
            post.setId(id);
            model.addAttribute("user", post);
            return "users/update";
        }
        postRepository.save(post);
        return "redirect:/posts/overview";
    }

    @PostMapping("/posts/delete/{id}")
    public String delete (@PathVariable("id") long id, @Valid Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("post: Delete was called with errors, perhaps the user (using id) was not found?");
            model.addAttribute("User", post);
            return "posts/delete";
        }
        postRepository.delete(post);
        return "redirect:/posts/overview";
    }
}