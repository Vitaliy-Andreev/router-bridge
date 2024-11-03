package ru.krsmon.bridge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.lang.NonNull;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import java.security.SecureRandom;

@Configuration
public class SecurityConfig {
    protected static final String AUTHORITY_ADMIN = "ADMIN";
    protected static final String[] MATCHERS = new String[]{"/metrics/**", "/router/**"};
    protected static final String AUTHORITY_ZABBIX = "ZABBIX";
    protected static final int SEED_LENGTH = 255;
    protected static final int STRENGTH = 13;

    @Bean
    SecurityFilterChain securityFilterChain(@NonNull HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(req -> req
                        .requestMatchers(MATCHERS)
                        .hasAnyAuthority(AUTHORITY_ADMIN, AUTHORITY_ZABBIX)
                        .anyRequest().authenticated())
                .build();
    }

    @Bean
    @Primary
    SecureRandom secureRandom() {
        try {
            return SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception ex) {
            return new SecureRandom(SecureRandom.getSeed(SEED_LENGTH));
        }
    }

    @Bean
    @Primary
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(STRENGTH, secureRandom());
    }

}
