package com.example.cafe.controller;

import com.example.cafe.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    private final MenuService menuService;
    public MenuController(MenuService menuService) { this.menuService = menuService; }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("menu", menuService.findAllAvailable());
        return "index";
    }

    @GetMapping("/menu")
    public String menuPage(Model model) {
        model.addAttribute("menu", menuService.findAll());
        return "menu";
    }
}
