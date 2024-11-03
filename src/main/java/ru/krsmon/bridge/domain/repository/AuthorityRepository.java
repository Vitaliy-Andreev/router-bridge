package ru.krsmon.bridge.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.krsmon.bridge.domain.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
