package fr.diginamic.repotp3c.controller;

import fr.diginamic.repotp3c.dto.CandidatureDto;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Candidature controller
 */
public interface ICandidatureController
{
    /**
     * Retrouve toutes les candidatures pour un admin
     * @return liste de candidatures
     */
    @GetMapping({"/get-all"})
    List<CandidatureDto> getAll();
}
