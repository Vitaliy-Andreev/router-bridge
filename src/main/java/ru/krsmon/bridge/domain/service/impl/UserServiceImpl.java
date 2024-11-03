package ru.krsmon.bridge.domain.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.krsmon.bridge.domain.model.User;
import ru.krsmon.bridge.domain.repository.UserRepository;
import ru.krsmon.bridge.domain.service.UserService;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        log.info("[USER]: Find user by username '{}'", username);
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) return user.get();
        else throw new UsernameNotFoundException(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByTelegramId(long telegramId) {
        log.info("[USER]: Find user by telegramId '{}'", telegramId);
        return userRepository.findByTelegramId(telegramId);
    }

}
