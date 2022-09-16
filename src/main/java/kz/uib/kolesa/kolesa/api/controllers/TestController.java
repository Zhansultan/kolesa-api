package kz.uib.kolesa.kolesa.api.controllers;

import kz.uib.kolesa.kolesa.api.models.requests.TestRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/")
    public Boolean test(@RequestBody TestRequest request) {

        Boolean response = false;

        String startDateStr = "2022-09-02T00:00:00.000";
        String endDateStr = "2022-09-02T23:59:59.999";
        LocalDateTime startDate = LocalDateTime.parse(startDateStr);
        LocalDateTime endDate = LocalDateTime.parse(endDateStr);

        if (request.getCreateDate().isAfter(startDate) && request.getCreateDate().isBefore(endDate)) {
            response = true;
        }

        return response;

    }
}
