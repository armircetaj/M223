package ch.samt.esercizio1.controller;


import ch.samt.esercizio1.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    private final List<User> users = new ArrayList<>();

    @GetMapping("/")
    public String index() {
        return "Hello";
    }
    @GetMapping("/{name}")
    public String name(Model model, @PathVariable String name) {
        model.addAttribute("name", name);
        return "Hello";
    }
    @GetMapping("/user/insert")
    public String insertUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", users);
        return "userInsert";
    }
    @PostMapping("/user/insert")
    public String saveUser(@ModelAttribute User user) {
        users.add(user);
        return "redirect:/user/insert";
    }
    @GetMapping("/load")
    public String loadUser(Model model, @RequestParam(value = "userId", required = false) Integer userId) {
        if(userId == null) {
            model.addAttribute("users", users);
        }
        else {
            User user = users.stream().filter(user1 -> user1.getId().equals(userId)).findFirst().orElse(new User(0, "User not found", ""));
            model.addAttribute("user", user.getName());
        }
        return "userLoad";
    }
}
