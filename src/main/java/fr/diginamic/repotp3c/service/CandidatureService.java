package fr.diginamic.repotp3c.service;

import fr.diginamic.repotp3c.dto.CandidatureDto;
import fr.diginamic.repotp3c.entity.Candidature;
import fr.diginamic.repotp3c.exception.ProblemException;
import fr.diginamic.repotp3c.mapper.ICandidatureMapper;
import fr.diginamic.repotp3c.repository.CandidatureRepository;
import fr.diginamic.repotp3c.validator.ICandidatureValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatureService implements ICandidatureService
{
    @Autowired
    private CandidatureRepository candidatureRepository;
    @Autowired
    private ICandidatureMapper ICandidatureMapper;
    @Autowired
    private ICandidatureValidator candidatureValidator;
    
    @Override
    public List<CandidatureDto> findAll()
    {
        return candidatureRepository.findAll().stream()
                                    .map(candidature -> ICandidatureMapper.toCandidatureDto(candidature)).toList();
    }
    
    @Override
    public void create(Candidature candidature) throws ProblemException
    {
        candidatureValidator.validerCandidature(candidature);
        candidatureRepository.save(candidature);
    }
}
