package kz.uib.kolesa.kolesa.api.dao.rowmappers;

import kz.uib.kolesa.kolesa.api.dao.entities.Ad;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdRowMapper implements RowMapper<Ad> {
    @Override
    public Ad mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ad ad = new Ad();
        ad.setId(rs.getLong("ad_id"));
        ad.setMarkId(rs.getLong("mark_id"));
        ad.setMarkName(rs.getString("mark_name"));
        ad.setModelId(rs.getLong("model_id"));
        ad.setModelName(rs.getString("model_name"));
        ad.setYear(rs.getInt("ad_year"));
        ad.setColorId(rs.getLong("color_id"));
        ad.setColorName(rs.getString("color_name"));
        ad.setIsCleared(rs.getBoolean("ad_cleared"));
        ad.setCityId(rs.getLong("city_id"));
        ad.setCityName(rs.getString("city_name"));
        ad.setPhoneNumber(rs.getString("ad_phone_number"));
        ad.setTransmission(rs.getString("ad_transmission"));
        ad.setWheelDrive(rs.getString("ad_wheel_drive"));
        ad.setFuelType(rs.getString("ad_fuel_type"));
        ad.setDescription(rs.getString("ad_description"));
        ad.setEngineCapacity(rs.getDouble("ad_engine_capacity"));

        return ad;
    }
}
