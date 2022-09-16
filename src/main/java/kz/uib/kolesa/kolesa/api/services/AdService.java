package kz.uib.kolesa.kolesa.api.services;

import kz.uib.kolesa.kolesa.api.dao.entities.Ad;
import kz.uib.kolesa.kolesa.api.dao.repositories.AdRepository;
import kz.uib.kolesa.kolesa.api.models.requests.AdCreateRequest;
import kz.uib.kolesa.kolesa.api.models.requests.AdEditRequest;
import kz.uib.kolesa.kolesa.api.models.responses.AdAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdService {

    private final AdRepository adRepository;

    public List<AdAllResponse> adGet(Long cityId, int page, int size) throws Exception {
        if (page < 1 || size < 1)
            throw new Exception("page and size must be > 0", null);
        int limit = size;
        int offset = size * (page - 1);

        List<Ad> ads = adRepository.getAll(cityId, limit, offset);

        return ads
                .stream()
                .map(ad -> new AdAllResponse(
                        ad.getId(),
                        ad.getMarkId(),
                        ad.getMarkName(),
                        ad.getModelId(),
                        ad.getModelName(),
                        ad.getYear(),
                        ad.getColorId(),
                        ad.getColorName(),
                        ad.getIsCleared(),
                        ad.getCityId(),
                        ad.getCityName(),
                        ad.getPhoneNumber(),
                        ad.getTransmission(),
                        ad.getWheelDrive(),
                        ad.getFuelType(),
                        ad.getDescription(),
                        ad.getEngineCapacity()
                ))
                .collect(Collectors.toList());
    }

    public void adEdit(Long id, AdEditRequest request) throws Exception {
        // проверяем есть ли запись по айди
        Ad ad = adRepository.getById(id);

        if (!id.equals(ad.getId())) {
            throw new Exception("id is request doesn't equals id is database");
        }

        adRepository.update(
                id,
                request.getMarkId(),
                request.getModelId(),
                request.getYear(),
                request.getColorId(),
                request.getIsCleared(),
                request.getCityId(),
                request.getPhoneNumber(),
                request.getTransmission(),
                request.getWheelDrive(),
                request.getFuelType(),
                request.getDescription(),
                request.getEngineCapacity());
    }

    public Long adCreate(AdCreateRequest request) {
        return adRepository.insert(request.getMarkId(), request.getModelId(), request.getYear(),
                request.getColorId(), request.getIsCleared(), request.getCityId(),
                request.getPhoneNumber(), request.getTransmission(), request.getWheelDrive(),
                request.getFuelType(), request.getDescription(), request.getEngineCapacity());
    }

    public void adDelete(Long id) {
        adRepository.delete(id);
    }
}
