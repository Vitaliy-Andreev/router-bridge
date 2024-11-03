package ru.krsmon.bridge.domain.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import ru.krsmon.bridge.domain.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Cacheable("users")
    Optional<User> findByUsername(@NonNull String username);

    Optional<User> findByTelegramId(@NonNull Long telegramId);

}
