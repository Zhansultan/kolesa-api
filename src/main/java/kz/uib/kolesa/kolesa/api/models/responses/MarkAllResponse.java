package kz.uib.kolesa.kolesa.api.models.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkAllResponse {

    private Long id;
    private String name;
    private Long countryId;
    private String countryName;

}
