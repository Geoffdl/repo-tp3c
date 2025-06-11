package fr.diginamic.repotp3c.repository;

import fr.diginamic.repotp3c.entity.Annonce;
import fr.diginamic.repotp3c.entity.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long>
{
    void deleteAllByAnnonce(Annonce annonce);
}
