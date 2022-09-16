package kz.uib.kolesa.kolesa.api.controllers;

import kz.uib.kolesa.kolesa.api.models.responses.MarkAllResponse;
import kz.uib.kolesa.kolesa.api.services.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/mark")
@RequiredArgsConstructor
public class MarkController {

    private final MarkService markService;

    @GetMapping("/all")
    public List<MarkAllResponse> getAll() {
        return markService.getAll();
    }
}
