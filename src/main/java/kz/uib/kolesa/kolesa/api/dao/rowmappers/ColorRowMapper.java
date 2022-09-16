package kz.uib.kolesa.kolesa.api.dao.rowmappers;

import kz.uib.kolesa.kolesa.api.dao.entities.Color;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ColorRowMapper implements RowMapper<Color> {
    @Override
    public Color mapRow(ResultSet rs, int rowNum) throws SQLException {
        Color color = new Color();
        color.setId(rs.getLong("id"));
        color.setName(rs.getString("name"));

        return color;
    }
}
