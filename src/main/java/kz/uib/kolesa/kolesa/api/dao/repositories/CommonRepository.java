package kz.uib.kolesa.kolesa.api.dao.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommonRepository {

    private final JdbcTemplate jdbcTemplate;

    public Long getNextValFromMainSeq() {
        String query = "select nextval('main_seq')";

        return jdbcTemplate.queryForObject(query, Long.class);
    }
}
