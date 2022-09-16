package kz.uib.kolesa.kolesa.api.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdEditRequest {

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
