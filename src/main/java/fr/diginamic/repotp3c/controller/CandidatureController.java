package fr.diginamic.repotp3c.controller;

import fr.diginamic.repotp3c.dto.CandidatureDto;
import fr.diginamic.repotp3c.service.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/candidature"})
public class CandidatureController
{
    @Autowired
    private CandidatureService candidatureService;
    
    @GetMapping({"/get-all"})
    public List<CandidatureDto> getAll()
    {
        return candidatureService.findAll();
    }
}
