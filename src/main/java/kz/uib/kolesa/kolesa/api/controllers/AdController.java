package kz.uib.kolesa.kolesa.api.controllers;

import kz.uib.kolesa.kolesa.api.models.requests.AdCreateRequest;
import kz.uib.kolesa.kolesa.api.models.requests.AdEditRequest;
import kz.uib.kolesa.kolesa.api.models.responses.AdAllResponse;
import kz.uib.kolesa.kolesa.api.services.AdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/ad")
@RequiredArgsConstructor
public class AdController {

    private final AdService adService;

    @GetMapping("/all")
    public List<AdAllResponse> adGet(@RequestParam(required = false) Long cityId,
                                     @RequestParam int page,
                                     @RequestParam int size) throws Exception {
        return adService.adGet(cityId, page, size);
    }

    @PutMapping("/edit/{id}")
    public void adEdit(@PathVariable Long id,
                       @RequestBody AdEditRequest request) throws Exception {
        adService.adEdit(id, request);
    }

    @PostMapping("/create")
    public Long adCreate(@RequestBody @Valid AdCreateRequest request) {
        return adService.adCreate(request);
    }

    @DeleteMapping("/delete/{id}")
    public void adDelete(@PathVariable Long id) {
        adService.adDelete(id);
    }

}
