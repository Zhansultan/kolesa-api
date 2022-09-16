package kz.uib.kolesa.kolesa.api.services;

import kz.uib.kolesa.kolesa.api.dao.repositories.ModelRepository;
import kz.uib.kolesa.kolesa.api.models.responses.ModelAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModelService {

    private final ModelRepository modelRepository;

    public List<ModelAllResponse> getAll() {
        return modelRepository
                .getAll()
                .stream()
                .map(model -> new ModelAllResponse(
                        model.getId(), model.getName(), model.getMarkId(), model.getMarkName()))
                .collect(Collectors.toList());
    }

}
