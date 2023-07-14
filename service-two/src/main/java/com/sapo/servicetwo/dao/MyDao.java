package com.sapo.servicetwo.dao;

import com.sapo.servicetwo.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MyDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<User> findAll(){
        String sql = "SELECT * FROM accounts";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    public Integer count(){
        String sql = "SELECT count(*) FROM accounts";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<User> findById(int id){
        String sql = "SELECT * FROM accounts where id = ? ";
        return jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    public void add(User user) {
        String sql = "insert into accounts (name, username) values (?, ?)";
        jdbcTemplate.update(sql,user.getName(), user.getUsername());
    }

    public User findByUsername(int  id){
        String sql = "SELECT * FROM accounts where id = :id";
        SqlParameterSource parameters = new MapSqlParameterSource("id", id);
        return namedParameterJdbcTemplate.queryForObject(sql, parameters, new BeanPropertyRowMapper<>(User.class));
    }
}
