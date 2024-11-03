package ru.krsmon.bridge.config;

import io.micrometer.core.aop.TimedAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConfig {

    @Bean
    TimedAspect timedAspect() {
        return new TimedAspect();
    }

}
