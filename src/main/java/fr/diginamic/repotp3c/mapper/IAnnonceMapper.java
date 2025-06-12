package fr.diginamic.repotp3c.mapper;

import fr.diginamic.repotp3c.dto.AnnonceDto;
import fr.diginamic.repotp3c.entity.Annonce;

/**
 * Annonce mapper
 */
public interface IAnnonceMapper
{
    /**
     * Map annonce to dto
     * @param annonce annonce
     * @return annonce dto
     */
    AnnonceDto toAnnonceDto(Annonce annonce);
}
