package kz.uib.kolesa.kolesa.api.services;

import kz.uib.kolesa.kolesa.api.dao.repositories.CountryRepository;
import kz.uib.kolesa.kolesa.api.models.responses.CountryAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<CountryAllResponse> getAll() {
        return countryRepository
                .getAll()
                .stream()
                .map(country -> new CountryAllResponse(
                        country.getId(), country.getName()))
                .collect(Collectors.toList());
    }

}
