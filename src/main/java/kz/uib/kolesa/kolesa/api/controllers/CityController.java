package kz.uib.kolesa.kolesa.api.controllers;

import kz.uib.kolesa.kolesa.api.models.responses.CityAllResponse;
import kz.uib.kolesa.kolesa.api.services.CityService;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("/all")
//    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public List<CityAllResponse> cityAll() {
        return cityService.getAll();
    }
}
