package kz.uib.kolesa.kolesa.api.dao.rowmappers;

import kz.uib.kolesa.kolesa.api.dao.entities.Mark;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarkRowMapper implements RowMapper<Mark> {
    @Override
    public Mark mapRow(ResultSet rs, int rowNum) throws SQLException {
        Mark mark = new Mark();
        mark.setId(rs.getLong("mark_id"));
        mark.setName(rs.getString("mark_name"));
        mark.setCountryId(rs.getLong("country_id"));
        mark.setCountryName(rs.getString("country_name"));

        return mark;
    }
}
