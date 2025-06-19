package com.projarq.taxes.infra.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.projarq.taxes.domain.Tax;
import com.projarq.taxes.domain.TaxRepository;

@Repository
public class PostgresTaxRepository implements TaxRepository {
    private final JdbcTemplate jdbcTemplate;

    public PostgresTaxRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Tax findByState(String state) {
        String sql = "SELECT state, rate FROM taxes WHERE state = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> 
            new Tax(rs.getString("state"), rs.getDouble("rate")), state);
    }
} 