package ru.krsmon.bridge.domain.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.krsmon.bridge.domain.model.User;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    /**
     * Find user by telegram ID
     *
     * @param telegramId user id from messaage
     * @return user or NULL
     */
    Optional<User> findByTelegramId(long telegramId);

}
