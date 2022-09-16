package kz.uib.kolesa.kolesa.api.dao.repositories;

import kz.uib.kolesa.kolesa.api.dao.entities.Mark;
import kz.uib.kolesa.kolesa.api.dao.rowmappers.MarkRowMapper;
import kz.uib.kolesa.kolesa.api.models.responses.MarkAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MarkRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Mark> getAll() {
        String query = "select mark.id   mark_id, " +
                "       mark.name mark_name, " +
                "       cou.id    country_id, " +
                "       cou.name  country_name " +
                "from marks mark " +
                "         inner join countries cou on cou.id = mark.country_id";

        return jdbcTemplate.query(query, new MarkRowMapper());
    }

}
