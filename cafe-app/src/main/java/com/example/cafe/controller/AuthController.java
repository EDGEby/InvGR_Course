package com.example.cafe.controller;

import com.example.cafe.model.User;
import com.example.cafe.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService){ this.userService = userService; }

    @GetMapping("/login")
    public String loginPage() { return "login"; }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        var ou = userService.authenticate(username, password);
        if (ou.isPresent()) {
            session.setAttribute("user", ou.get());
            return "redirect:/";
        } else {
            model.addAttribute("error", "Invalid credentials or blocked");
            return "login";
        }
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user,
                         @RequestParam String password,
                         HttpSession session,
                         Model model) {
        User created = userService.register(user, password);
        session.setAttribute("user", created);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
