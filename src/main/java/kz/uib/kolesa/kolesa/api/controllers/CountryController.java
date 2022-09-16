package kz.uib.kolesa.kolesa.api.controllers;

import kz.uib.kolesa.kolesa.api.models.responses.AdAllResponse;
import kz.uib.kolesa.kolesa.api.models.responses.CountryAllResponse;
import kz.uib.kolesa.kolesa.api.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/all")
    public List<CountryAllResponse> getAll() {
        return countryService.getAll();
    }
}
