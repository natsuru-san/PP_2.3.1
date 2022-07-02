package app.controller;

import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import app.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getAllUsers(Model model) {
        model.addAttribute("listUsers", userService.getListUsers());
        return "users";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }
    @PostMapping("/create")
    @Transactional
    public String creatingNewUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    @Transactional
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(Long.parseLong(id));
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    @Transactional
    public String updateUser(@PathVariable long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "single_user";
    }

    @PostMapping("/change")
    @Transactional
    public String changeUser(@ModelAttribute User user) {
        userService.changeUser(user);
        return "redirect:/";
    }
}
