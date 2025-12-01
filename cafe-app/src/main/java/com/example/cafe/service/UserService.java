package com.example.cafe.service;

import com.example.cafe.dao.UserDao;
import com.example.cafe.model.User;
import com.example.cafe.util.PasswordUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;
    public UserService(UserDao userDao) { this.userDao = userDao; }

    public Optional<User> authenticate(String username, String plainPassword) {
        Optional<User> ou = userDao.findByUsername(username);
        if (ou.isEmpty()) return Optional.empty();
        User u = ou.get();
        if (u.isBlocked()) return Optional.empty();
        if (PasswordUtil.verifyPassword(plainPassword, u.getPasswordHash())) {
            return Optional.of(u);
        }
        return Optional.empty();
    }

    public User register(User u, String plainPassword) {
        u.setPasswordHash(PasswordUtil.hashPassword(plainPassword));
        if (u.getRole() == null) u.setRole("USER");
        int id = userDao.save(u);
        u.setId(id);
        return u;
    }
}
