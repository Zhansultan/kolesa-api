package kz.uib.kolesa.kolesa.api.dao.rowmappers;

import kz.uib.kolesa.kolesa.api.dao.entities.Model;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelRowMapper implements RowMapper<Model> {
    @Override
    public Model mapRow(ResultSet rs, int rowNum) throws SQLException {
        Model model = new Model();
        model.setId(rs.getLong("model_id"));
        model.setName(rs.getString("model_name"));
        model.setMarkId(rs.getLong("mark_id"));
        model.setMarkName(rs.getString("mark_name"));

        return model;
    }
}
