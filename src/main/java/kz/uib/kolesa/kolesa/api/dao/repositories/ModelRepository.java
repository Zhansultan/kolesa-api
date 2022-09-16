package kz.uib.kolesa.kolesa.api.dao.repositories;

import kz.uib.kolesa.kolesa.api.dao.entities.Model;
import kz.uib.kolesa.kolesa.api.dao.rowmappers.ModelRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ModelRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Model> getAll() {
        String query = "select mod.id    model_id, " +
                "       mod.name  model_name, " +
                "       mark.id   mark_id, " +
                "       mark.name mark_name " +
                "from models mod " +
                "         inner join marks mark on mark.id = mod.mark_id";

        return jdbcTemplate.query(query, new ModelRowMapper());
    }
}
