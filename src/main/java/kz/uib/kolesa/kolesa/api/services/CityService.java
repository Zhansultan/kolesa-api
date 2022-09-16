package kz.uib.kolesa.kolesa.api.services;

import kz.uib.kolesa.kolesa.api.dao.repositories.CityRepository;
import kz.uib.kolesa.kolesa.api.models.responses.CityAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<CityAllResponse> getAll() {
        return cityRepository
                .getAll()
                .stream()
                .map(city -> new CityAllResponse(
                        city.getId(), city.getName()))
                .collect(Collectors.toList());
    }
}
