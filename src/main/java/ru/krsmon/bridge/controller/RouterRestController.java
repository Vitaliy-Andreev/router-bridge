package ru.krsmon.bridge.controller;

import io.micrometer.core.annotation.Timed;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.krsmon.bridge.dto.SurveyRequest;
import ru.krsmon.bridge.dto.SurveyResponse;
import ru.krsmon.bridge.dto.enums.Brand;
import ru.krsmon.bridge.service.SurveyService;

@Slf4j
@RestController
@RequestMapping("/router")
@CrossOrigin(methods = RequestMethod.POST, maxAge = 3600)
public class RouterRestController {
    private final SurveyService simpleService;
    private final SurveyService sshService;
    private final SurveyService telnetService;

    public RouterRestController(@Qualifier("SIMPLE") SurveyService simpleService,
                                @Qualifier("SSH")SurveyService sshService,
                                @Qualifier("TELNET")SurveyService telnetService) {
        this.simpleService = simpleService;
        this.sshService = sshService;
        this.telnetService = telnetService;
    }

    @PostMapping("/{brand}/ssh")
    @Timed(value = "survey-ssh-timed", description = "Time to survey router devices by SSH.", extraTags = {"brand", "#brand"})
    public ResponseEntity<SurveyResponse> surveySSH(@PathVariable Brand brand,
                                                    @RequestBody @Valid SurveyRequest request) {
        return ResponseEntity.ok(sshService.executeSurvey(request, brand));
    }

    @PostMapping("/{brand}/telnet")
    @Timed(value = "survey-telnet-timed", description = "Time to survey router devices by TELNET.", extraTags = {"brand", "#brand"})
    public ResponseEntity<SurveyResponse> surveyTelnet(@PathVariable Brand brand,
                                                       @RequestBody @Valid SurveyRequest request) {
        return ResponseEntity.ok(telnetService.executeSurvey(request, brand));
    }

    @PostMapping("/{brand}/simple")
    @Timed(value = "survey-simple-timed", description = "Time to simple survey router devices.", extraTags = {"brand", "#brand"})
    public ResponseEntity<SurveyResponse> surveySimple(@PathVariable Brand brand,
                                                       @RequestBody @Valid SurveyRequest request) {
        return ResponseEntity.ok(simpleService.executeSurvey(request, brand));
    }

}
