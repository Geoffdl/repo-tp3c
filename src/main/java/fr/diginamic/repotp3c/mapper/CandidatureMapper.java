package fr.diginamic.repotp3c.mapper;

import fr.diginamic.repotp3c.dto.CandidatureDto;
import fr.diginamic.repotp3c.entity.Candidature;
import org.springframework.stereotype.Component;

@Component
public class CandidatureMapper implements ICandidatureMapper
{
    @Override
    public CandidatureDto toCandidatureDto(Candidature candidature)
    {
        CandidatureDto dto = new CandidatureDto();
        dto.setId(candidature.getId());
        dto.setLettreMotivation(candidature.getLettreMotivation());
        dto.setCandidatUsername(candidature.getUserApp().getUsername());
        return dto;
    }
}
