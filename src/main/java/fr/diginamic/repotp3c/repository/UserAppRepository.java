package fr.diginamic.repotp3c.repository;

import fr.diginamic.repotp3c.entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long>
{
    Optional<UserApp> findByUsername(String username);
}
