package kz.uib.kolesa.kolesa.api.dao.repositories;

import kz.uib.kolesa.kolesa.api.dao.entities.Country;
import kz.uib.kolesa.kolesa.api.dao.rowmappers.CountryRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CountryRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Country> getAll() {
        String query = "select id, name from countries";

        return jdbcTemplate.query(query, new CountryRowMapper());
    }

}
