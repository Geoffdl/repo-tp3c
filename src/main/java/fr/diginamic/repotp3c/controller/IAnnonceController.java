package fr.diginamic.repotp3c.controller;

import fr.diginamic.repotp3c.dto.AnnonceDto;
import fr.diginamic.repotp3c.dto.CandidatureDto;
import fr.diginamic.repotp3c.entity.Annonce;
import fr.diginamic.repotp3c.entity.Candidature;
import fr.diginamic.repotp3c.exception.ProblemException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Annonce controller
 */
public interface IAnnonceController
{
    /**
     * Retourne toutes les annonces
     * @return toutes les annonces
     */
    @GetMapping({"/get-all"})
    List<AnnonceDto> getAll();
    
    /**
     * Retourne les annonces de l'utilisateur connecté (candidat ou recruteur)
     * @param request element d'identification de l'utilisateur
     * @return si candidat toutes les annonces où j'ai postulé, si recruteur toutes les annonces que j'ai crée
     * @throws Exception erreur
     */
    @GetMapping({"/get-my-annonce-list"})
    List<AnnonceDto> getUserAnnonceList(HttpServletRequest request) throws Exception;
    
    /**
     * Crée une annonce
     * @param annonce nouvelle annonce
     * @param request identifie l'utilisateur créateur
     * @return méssgae de confirmation
     * @throws Exception erreur
     */
    @PostMapping({"/create"})
    String createAnnonce(@RequestBody Annonce annonce, HttpServletRequest request) throws Exception;
    
    /**
     * Permet à un utilisateur candidat de postuler à une annonce
     * @param idAnnonce   id de l'annonce
     * @param candidature candidature
     * @param request     identification de l'utilisateur connecté
     * @return l'annonce avec candidature générée
     * @throws Exception erreur
     */
    @PostMapping({"/candidate-by-id/{idAnnonce}"})
    AnnonceDto candidateByAnnonceId(@PathVariable Long idAnnonce, @RequestBody Candidature candidature,
          HttpServletRequest request) throws Exception;
    
    /**
     * Supprime une annonce pour un admin
     * @param idAnnonce id de l'annonce
     * @return méssage de confirmation
     * @throws ProblemException annonce introuvable
     */
    @DeleteMapping({"/delete-by-id/{idAnnonce}"})
    String deleteByAnnonceId(@PathVariable Long idAnnonce) throws ProblemException;
    
    /**
     * Retourne la liste de candidatures par id liées à l'utilisateur connecté
     * @param idAnnonce id de l'annonce
     * @param request   identification utilisateur
     * @return liste de candidature
     * @throws Exception erreur de parsing
     */
    @GetMapping({"/get-candidature-list-by-id/{idAnnonce}"})
    List<CandidatureDto> getAllCandidatureByAnnonceId(@PathVariable Long idAnnonce,
          HttpServletRequest request) throws
          Exception;
}
