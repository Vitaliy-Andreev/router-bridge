package ru.krsmon.bridge.service;

import org.springframework.lang.NonNull;
import ru.krsmon.bridge.dto.SurveyRequest;
import ru.krsmon.bridge.dto.SurveyResponse;
import ru.krsmon.bridge.dto.enums.Brand;

public interface SurveyService {

    /**
     * Execute checks devices on router
     *
     * @param request credentials and list devices
     * @param brand brand of router
     * @return results of check
     */
    SurveyResponse executeSurvey(@NonNull SurveyRequest request, @NonNull Brand brand);

}
