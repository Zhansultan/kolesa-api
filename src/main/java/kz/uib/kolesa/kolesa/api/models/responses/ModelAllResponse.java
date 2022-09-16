package kz.uib.kolesa.kolesa.api.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelAllResponse {

    private Long id;
    private String name;
    private Long markId;
    private String markName;

}
