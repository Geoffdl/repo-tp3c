package fr.diginamic.repotp3c.mapper;

import fr.diginamic.repotp3c.dto.CandidatureDto;
import fr.diginamic.repotp3c.entity.Candidature;

/**
 * candidature dto mapper
 */
public interface ICandidatureMapper
{
    /**
     * candidature to dto
     * @param candidature candidature
     * @return dto
     */
    CandidatureDto toCandidatureDto(Candidature candidature);
}
