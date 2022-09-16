package kz.uib.kolesa.kolesa.api.dao.entities;

import lombok.Data;

@Data
public class Mark {

    private Long id;
    private String name;
    private Long countryId;
    private String countryName;

}
