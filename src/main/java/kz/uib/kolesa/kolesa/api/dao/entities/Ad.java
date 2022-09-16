package kz.uib.kolesa.kolesa.api.dao.entities;

import lombok.Data;

@Data
public class Ad {

    private Long id;
    private Long markId;
    private String markName;
    private Long modelId;
    private String modelName;
    private Integer year;
    private Long colorId;
    private String colorName;
    private Boolean isCleared;
    private Long cityId;
    private String cityName;
    private String phoneNumber;
    private String transmission;
    private String wheelDrive;
    private String fuelType;
    private String description;
    private Double engineCapacity;

}
