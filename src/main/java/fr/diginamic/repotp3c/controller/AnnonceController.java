package fr.diginamic.repotp3c.controller;

import fr.diginamic.repotp3c.dto.AnnonceDto;
import fr.diginamic.repotp3c.dto.CandidatureDto;
import fr.diginamic.repotp3c.entity.Annonce;
import fr.diginamic.repotp3c.entity.Candidature;
import fr.diginamic.repotp3c.entity.UserApp;
import fr.diginamic.repotp3c.exception.ProblemException;
import fr.diginamic.repotp3c.service.AnnonceService;
import fr.diginamic.repotp3c.utils.HttpUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/annonce"})
public class AnnonceController
{
    @Autowired
    private AnnonceService annonceService;
    @Autowired
    private HttpUtils httpUtils;
    
    @GetMapping({"/get-all"})
    public List<AnnonceDto> getAll()
    {
        return annonceService.getAll();
    }
    
    @GetMapping({"/get-my-annonce-list"})
    public List<AnnonceDto> getUserAnnonceList(HttpServletRequest request) throws Exception
    {
        UserApp userApp = httpUtils.getUserApp(request);
        
        return annonceService.getAnnonceListForCandidatOrRecruteur(userApp);
    }
    
    @PostMapping({"/create"})
    public String createAnnonce(@RequestBody Annonce annonce, HttpServletRequest request) throws Exception
    {
        UserApp recruteur = httpUtils.getUserApp(request);
        annonceService.create(annonce, recruteur);
        return "annonce créee";
    }
    
    @PostMapping({"/candidate-by-id/{idAnnonce}"})
    public AnnonceDto candidateByAnnonceId(@PathVariable Long idAnnonce, @RequestBody Candidature candidature,
          HttpServletRequest request) throws Exception
    {
        UserApp candidat = httpUtils.getUserApp(request);
        
        return annonceService.addCandidatToAnnonce(idAnnonce, candidature, candidat);
    }
    
    @DeleteMapping({"/delete-by-id/{idAnnonce}"})
    public String deleteByAnnonceId(@PathVariable Long idAnnonce) throws ProblemException
    {
        annonceService.deleteById(idAnnonce);
        return "annonce supprimée";
    }
    
    @GetMapping({"/get-candidature-list-by-id/{idAnnonce}"})
    public List<CandidatureDto> getAllCandidatureByAnnonceId(@PathVariable Long idAnnonce,
          HttpServletRequest request) throws
          Exception
    {
        return annonceService.getAllCandidatsById(idAnnonce, request);
    }
}
