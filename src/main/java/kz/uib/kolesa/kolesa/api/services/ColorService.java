package kz.uib.kolesa.kolesa.api.services;

import kz.uib.kolesa.kolesa.api.dao.repositories.ColorRepository;
import kz.uib.kolesa.kolesa.api.models.responses.ColorAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColorService {

    private final ColorRepository colorRepository;

    public List<ColorAllResponse> getAll() {
        return colorRepository
                .getAll()
                .stream()
                .map(color -> new ColorAllResponse(
                        color.getId(), color.getName()))
                .collect(Collectors.toList());
    }
}
