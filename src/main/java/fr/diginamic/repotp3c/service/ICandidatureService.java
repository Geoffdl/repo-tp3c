package fr.diginamic.repotp3c.service;

import fr.diginamic.repotp3c.dto.CandidatureDto;
import fr.diginamic.repotp3c.entity.Candidature;
import fr.diginamic.repotp3c.exception.ProblemException;

import java.util.List;

/**
 * candidature service
 */
public interface ICandidatureService
{
    /**
     * retrouve toutes les candidatures
     * @return liste de candidatures
     */
    List<CandidatureDto> findAll();
    
    /**
     * crée une candidature
     * @param candidature candidature
     * @throws ProblemException exception
     */
    void create(Candidature candidature) throws ProblemException;
}
