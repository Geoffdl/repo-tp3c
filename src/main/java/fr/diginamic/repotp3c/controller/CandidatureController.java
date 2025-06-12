package fr.diginamic.repotp3c.controller;

import fr.diginamic.repotp3c.dto.CandidatureDto;
import fr.diginamic.repotp3c.service.ICandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/candidature"})
public class CandidatureController implements ICandidatureController
{
    @Autowired
    private ICandidatureService candidatureService;
    
    @GetMapping({"/get-all"})
    @Override
    public List<CandidatureDto> getAll()
    {
        return candidatureService.findAll();
    }
}
