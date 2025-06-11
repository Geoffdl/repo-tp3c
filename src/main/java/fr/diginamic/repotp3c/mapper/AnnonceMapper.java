package fr.diginamic.repotp3c.mapper;

import fr.diginamic.repotp3c.dto.AnnonceDto;
import fr.diginamic.repotp3c.dto.CandidatureDto;
import fr.diginamic.repotp3c.entity.Annonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnnonceMapper
{
    @Autowired
    CandidatureMapper candidatureMapper;
    
    public AnnonceDto toAnnonceDto(Annonce annonce)
    {
        AnnonceDto dto = new AnnonceDto();
        dto.setId(annonce.getId());
        dto.setTitre(annonce.getTitre());
        dto.setDescription(annonce.getDescription());
        dto.setRecruteurUsername(annonce.getUserApp().getUsername());
        if (annonce.getCandidatures() != null)
        {
            List<CandidatureDto> candidatureDTOs = annonce.getCandidatures().stream()
                                                          .map(candidature -> candidatureMapper.toCandidatureDto(
                                                                candidature))
                                                          .collect(Collectors.toList());
            dto.setCandidatures(candidatureDTOs);
        }
        return dto;
    }
}
