package com.example.cafe.dao;

import com.example.cafe.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDao {
    private final JdbcTemplate jdbc;

    public UserDao(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    private final RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setUsername(rs.getString("username"));
        u.setPasswordHash(rs.getString("password_hash"));
        u.setFullName(rs.getString("full_name"));
        u.setEmail(rs.getString("email"));
        u.setRole(rs.getString("role"));
        u.setLoyaltyPoints(rs.getInt("loyalty_points"));
        u.setBlocked(rs.getBoolean("blocked"));
        return u;
    };

    public Optional<User> findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbc.query(sql, new Object[]{username}, userRowMapper).stream().findFirst();
    }

    public Optional<User> findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbc.query(sql, new Object[]{id}, userRowMapper).stream().findFirst();
    }

    public int save(User u) {
        String sql = "INSERT INTO users(username, password_hash, full_name, email, role) VALUES (?,?,?,?,?) RETURNING id";
        return jdbc.queryForObject(sql, new Object[]{
            u.getUsername(), u.getPasswordHash(), u.getFullName(), u.getEmail(), u.getRole()
        }, Integer.class);
    }

    public void updateLoyalty(int userId, int points) {
        String sql = "UPDATE users SET loyalty_points = loyalty_points + ? WHERE id = ?";
        jdbc.update(sql, points, userId);
    }

    public void blockUser(int userId) {
        String sql = "UPDATE users SET blocked = TRUE WHERE id = ?";
        jdbc.update(sql, userId);
    }
}
