package kz.uib.kolesa.kolesa.api.dao.repositories;

import kz.uib.kolesa.kolesa.api.dao.entities.Color;
import kz.uib.kolesa.kolesa.api.dao.rowmappers.ColorRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ColorRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Color> getAll() {
        String query = "select id, name from colors";

        return jdbcTemplate.query(query, new ColorRowMapper());
    }

}
