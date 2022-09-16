package kz.uib.kolesa.kolesa.api.models.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdCreateRequest {

    @NotNull(message = "markId mustn't be null")
    private Long markId;
    @NotNull(message = "modelId mustn't be null")
    private Long modelId;
    @NotNull(message = "year mustn't be null")
    private Integer year;
    @NotNull(message = "colorId mustn't be null")
    private Long colorId;
    @NotNull(message = "isCleared mustn't be null")
    private Boolean isCleared;
    @NotNull(message = "cityId mustn't be null")
    private Long cityId;
    @NotNull(message = "phoneNumber mustn't be null")
    private String phoneNumber;
    @NotNull(message = "transmission mustn't be null")
    private String transmission;
    @NotNull(message = "wheelDrive mustn't be null")
    private String wheelDrive;
    @NotNull(message = "fuelType mustn't be null")
    private String fuelType;
    @NotNull(message = "description mustn't be null")
    private String description;
    @NotNull(message = "engineCapacity mustn't be null")
    private Double engineCapacity;

}
