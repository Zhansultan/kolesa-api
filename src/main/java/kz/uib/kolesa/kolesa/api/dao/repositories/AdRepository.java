package kz.uib.kolesa.kolesa.api.dao.repositories;

import io.micrometer.core.instrument.util.StringUtils;
import kz.uib.kolesa.kolesa.api.dao.entities.Ad;
import kz.uib.kolesa.kolesa.api.dao.rowmappers.AdRowMapper;
import lombok.RequiredArgsConstructor;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdRepository {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final CommonRepository commonRepository;

    public List<Ad> getAll(Long cityId, int limit, int offset) {
        String query = "select ad.id              ad_id, " +
                "       mark.id            mark_id, " +
                "       mark.name          mark_name, " +
                "       mod.id             model_id, " +
                "       mod.name           model_name, " +
                "       ad.year            ad_year, " +
                "       col.id             color_id, " +
                "       col.name           color_name, " +
                "       ad.cleared         ad_cleared, " +
                "       city.id            city_id, " +
                "       city.name          city_name, " +
                "       ad.phone_number    ad_phone_number, " +
                "       ad.transmission    ad_transmission, " +
                "       ad.wheel_drive     ad_wheel_drive, " +
                "       ad.fuel_type       ad_fuel_type, " +
                "       ad.description     ad_description, " +
                "       ad.engine_capacity ad_engine_capacity " +
                "from ads ad " +
                "         inner join cities city on city.id = ad.city_id " +
                "         inner join colors col on col.id = ad.color_id " +
                "         inner join marks mark on mark.id = ad.mark_id " +
                "         inner join models mod on ad.model_id = mod.id " +
                (cityId == null ? "" : "where ad.city_id = :cityId ") +
                "limit :limit offset :offset";

        return namedParameterJdbcTemplate.query(
                query,
                new MapSqlParameterSource("cityId", cityId)
                        .addValue("limit", limit)
                        .addValue("offset", offset),
                new AdRowMapper());
    }

    public Ad getById(Long id) throws Exception {
        try {
            String query = "select ad.id              ad_id, " +
                    "       mark.id            mark_id, " +
                    "       mark.name          mark_name, " +
                    "       mod.id             model_id, " +
                    "       mod.name           model_name, " +
                    "       ad.year            ad_year, " +
                    "       col.id             color_id, " +
                    "       col.name           color_name, " +
                    "       ad.cleared         ad_cleared, " +
                    "       city.id            city_id, " +
                    "       city.name          city_name, " +
                    "       ad.phone_number    ad_phone_number, " +
                    "       ad.transmission    ad_transmission, " +
                    "       ad.wheel_drive     ad_wheel_drive, " +
                    "       ad.fuel_type       ad_fuel_type, " +
                    "       ad.description     ad_description, " +
                    "       ad.engine_capacity ad_engine_capacity " +
                    "from ads ad " +
                    "         inner join cities city on city.id = ad.city_id " +
                    "         inner join colors col on col.id = ad.color_id " +
                    "         inner join marks mark on mark.id = ad.mark_id " +
                    "         inner join models mod on ad.model_id = mod.id " +
                    "where ad.id = ? ";

            return jdbcTemplate.queryForObject(
                    query,
                    new AdRowMapper(),
                    id);
        } catch (EmptyResultDataAccessException e) {
            throw new Exception("Ad not found");
        }

    }

    public void update(Long id, Long markId, Long modelId, Integer year, Long colorId, Boolean isCleared,
                       Long cityId, String phoneNumber, String transmission, String wheeDrive,
                       String fuelType, String description, Double engineCapacity) {
        final StringBuilder query = new StringBuilder();
        query.append("update ads set id = ?");

        StringBuilder updates = new StringBuilder();

        if (markId != null) {
            updates.append(", mark_id = ").append(markId);
        }

        if (modelId != null) {
            updates.append(", model_id = ").append(modelId);
        }

        if (year != null) {
            updates.append(", year = ").append(year);
        }

        if (colorId != null) {
            updates.append(", color_id = ").append(colorId);
        }

        if (isCleared != null) {
            updates.append(", cleared = ").append(isCleared);
        }

        if (cityId != null) {
            updates.append(", city_id = ").append(cityId);
        }

        if (StringUtils.isNotBlank(phoneNumber)) {
            updates.append(", phone_number = '").append(phoneNumber).append("'");
        }

        if (StringUtils.isNotBlank(transmission)) {
            updates.append(", transmission = '").append(transmission).append("'");
        }

        if (StringUtils.isNotBlank(wheeDrive)) {
            updates.append(", wheel_drive = '").append(wheeDrive).append("'");
        }

        if (StringUtils.isNotBlank(fuelType)) {
            updates.append(", fuel_type = '").append(fuelType).append("'");
        }

        if (StringUtils.isNotBlank(description)) {
            updates.append(", descriptiom = '").append(description).append("'");
        }

        if (engineCapacity != null) {
            updates.append(", engine_capacity = ").append(engineCapacity);
        }

        query.append(updates)
                .append("where id = ?");

        LinkedList<Object> arguments = new LinkedList<>();

        jdbcTemplate.update(query.toString(), id, id);

    }

    public Long insert(Long markId, Long modelId, Integer year, Long colorId,
                       Boolean isCleared, Long cityId, String phoneNumber, String transmission, String wheelDrive,
                       String fuelType, String description, Double engineCapacity) {
        String query = "insert into ads(id, mark_id, model_id, year, color_id, cleared, city_id, " +
                "phone_number, transmission, wheel_drive, fuel_type, description, engine_capacity) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Long id = commonRepository.getNextValFromMainSeq();

       jdbcTemplate.update(query,
               id, markId,modelId, year, colorId, isCleared, cityId, phoneNumber,
               transmission, wheelDrive, fuelType, description, engineCapacity);

       return id;
    }

    public void delete(Long id) {
        String query = "delete from ads where id = ?";

        jdbcTemplate.update(query, id);
    }

}
