package kz.uib.kolesa.kolesa.api.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdAllResponse {

    private Long id;
    private Long markId;
    private String markName;
    private Long modelId;
    private String modelName;
    private int year;
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
    private double engineCapacity;

}
