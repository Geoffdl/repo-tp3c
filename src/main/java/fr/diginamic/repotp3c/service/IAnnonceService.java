package fr.diginamic.repotp3c.service;

import fr.diginamic.repotp3c.dto.AnnonceDto;
import fr.diginamic.repotp3c.dto.CandidatureDto;
import fr.diginamic.repotp3c.entity.Annonce;
import fr.diginamic.repotp3c.entity.Candidature;
import fr.diginamic.repotp3c.entity.UserApp;
import fr.diginamic.repotp3c.exception.ProblemException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Annonce service
 */
public interface IAnnonceService
{
    /**
     * Retourne toutes les annonces
     * @return toutes les annonces
     */
    List<AnnonceDto> getAll();
    
    /**
     * Retourne les annonces de l'utilisateur connecté (candidat ou recruteur)
     * @param userApp element d'identification de l'utilisateur
     * @return si candidat toutes les annonces où j'ai postulé, si recruteur toutes les annonces que j'ai crée
     * @throws ProblemException erreur de validation
     */
    List<AnnonceDto> getAnnonceListForCandidatOrRecruteur(UserApp userApp) throws ProblemException;
    
    /**
     * crée une annonce
     * @param annonce   annonce
     * @param recruteur recruteur
     * @return confirmation
     * @throws ProblemException erreur de validation ou insertion
     */
    @Transactional
    String create(Annonce annonce, UserApp recruteur) throws ProblemException;
    
    /**
     * Permet à un utilisateur candidat de postuler à une annonce
     * @param idAnnonce   id de l'annonce
     * @param candidature candidature
     * @param candidat    utilisateur
     * @return confirmation
     * @throws ProblemException erreur d'insertion ou validation
     */
    @Transactional
    AnnonceDto addCandidatToAnnonce(Long idAnnonce, Candidature candidature, UserApp candidat) throws
          ProblemException;
    
    /**
     * Supprime une annonce par id
     * @param idAnnonce annonce
     * @throws ProblemException erreur
     */
    @Transactional
    void deleteById(Long idAnnonce) throws ProblemException;
    
    List<CandidatureDto> getAllCandidatsById(Long idAnnonce, HttpServletRequest request) throws Exception;
}
