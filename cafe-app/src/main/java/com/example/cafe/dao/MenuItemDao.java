package com.example.cafe.dao;

import com.example.cafe.model.MenuItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class MenuItemDao {
    private final JdbcTemplate jdbc;

    public MenuItemDao(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    private final RowMapper<MenuItem> mapper = (ResultSet rs, int rowNum) -> {
        MenuItem m = new MenuItem();
        m.setId(rs.getInt("id"));
        m.setName(rs.getString("name"));
        m.setDescription(rs.getString("description"));
        m.setPrice(rs.getBigDecimal("price"));
        m.setAvailable(rs.getBoolean("available"));
        return m;
    };

    public List<MenuItem> findAll() {
        return jdbc.query("SELECT * FROM menu_items ORDER BY id", mapper);
    }

    public List<MenuItem> findAllAvailable() {
        return jdbc.query("SELECT * FROM menu_items WHERE available = TRUE ORDER BY id", mapper);
    }
}
