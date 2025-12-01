package com.example.cafe.controller;

import com.example.cafe.model.MenuItem;
import com.example.cafe.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final MenuService menuService;
    public ApiController(MenuService menuService) { this.menuService = menuService; }

    @GetMapping("/menu")
    public List<MenuItem> menu() {
        return menuService.findAllAvailable();
    }
}
