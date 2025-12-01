package com.example.cafe.service;

import com.example.cafe.dao.MenuItemDao;
import com.example.cafe.model.MenuItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final MenuItemDao dao;
    public MenuService(MenuItemDao dao) { this.dao = dao; }
    public List<MenuItem> findAll() { return dao.findAll(); }
    public List<MenuItem> findAllAvailable() { return dao.findAllAvailable(); }
}
