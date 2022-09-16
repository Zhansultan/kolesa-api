package kz.uib.kolesa.kolesa.api.services;

import kz.uib.kolesa.kolesa.api.dao.repositories.MarkRepository;
import kz.uib.kolesa.kolesa.api.models.responses.MarkAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MarkService {

    private final MarkRepository markRepository;

    public List<MarkAllResponse> getAll() {
        return markRepository
                .getAll()
                .stream()
                .map(mark -> new MarkAllResponse(
                        mark.getId(), mark.getName(), mark.getCountryId(), mark.getCountryName()))
                .collect(Collectors.toList());
    }

}
