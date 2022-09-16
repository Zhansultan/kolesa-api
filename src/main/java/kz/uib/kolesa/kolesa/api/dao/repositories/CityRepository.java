package kz.uib.kolesa.kolesa.api.dao.repositories;

import kz.uib.kolesa.kolesa.api.dao.entities.City;
import kz.uib.kolesa.kolesa.api.dao.rowmappers.CityRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CityRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<City> getAll() {
        try {
            String query = "select id, name from cities";

            return jdbcTemplate.query(query, new CityRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
