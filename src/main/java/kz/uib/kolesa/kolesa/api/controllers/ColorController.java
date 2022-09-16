package kz.uib.kolesa.kolesa.api.controllers;

import kz.uib.kolesa.kolesa.api.models.responses.ColorAllResponse;
import kz.uib.kolesa.kolesa.api.services.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/color")
@RequiredArgsConstructor
public class ColorController {

    private final ColorService colorService;

    @GetMapping("all")
    public List<ColorAllResponse> getAll() {
        return colorService.getAll();
    }

}
