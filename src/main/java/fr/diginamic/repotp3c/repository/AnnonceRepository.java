package fr.diginamic.repotp3c.repository;

import fr.diginamic.repotp3c.entity.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long>
{
    List<Annonce> findAllByUserAppUsername(String userAppUsername);
    
    List<Annonce> getAllById(Long id);
    
    @Query("SELECT a FROM Annonce a JOIN a.candidatures c WHERE c.userApp.username = :username")
    List<Annonce> findAllByCandidatUsername(@Param("username") String username);
}
