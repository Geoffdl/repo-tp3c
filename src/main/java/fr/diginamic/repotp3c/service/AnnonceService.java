package fr.diginamic.repotp3c.service;

import fr.diginamic.repotp3c.dto.AnnonceDto;
import fr.diginamic.repotp3c.dto.CandidatureDto;
import fr.diginamic.repotp3c.entity.Annonce;
import fr.diginamic.repotp3c.entity.Candidature;
import fr.diginamic.repotp3c.entity.Role;
import fr.diginamic.repotp3c.entity.UserApp;
import fr.diginamic.repotp3c.exception.ProblemException;
import fr.diginamic.repotp3c.mapper.AnnonceMapper;
import fr.diginamic.repotp3c.mapper.CandidatureMapper;
import fr.diginamic.repotp3c.repository.AnnonceRepository;
import fr.diginamic.repotp3c.repository.CandidatureRepository;
import fr.diginamic.repotp3c.repository.UserAppRepository;
import fr.diginamic.repotp3c.utils.HttpUtils;
import fr.diginamic.repotp3c.validator.IAnnonceValidator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnnonceService
{
    @Autowired
    CandidatureMapper candidatureMapper;
    @Autowired
    private AnnonceRepository annonceRepository;
    @Autowired
    private CandidatureService candidatureService;
    @Autowired
    private UserAppService userAppService;
    @Autowired
    private HttpUtils httpUtils;
    @Autowired
    private UserAppRepository userAppRepository;
    @Autowired
    private AnnonceMapper annonceMapper;
    @Autowired
    private CandidatureRepository candidatureRepository;
    @Autowired
    private IAnnonceValidator annonceValidator;
    
    public List<AnnonceDto> getAll()
    {
        return annonceRepository.findAll().stream().map(a -> annonceMapper.toAnnonceDto(a)).toList();
    }
    
    public List<AnnonceDto> getAnnonceListForCandidatOrRecruteur(UserApp userApp) throws ProblemException
    {
        if (userApp.getRole() == Role.CANDIDAT)
        {
            return annonceRepository.findAllByCandidatUsername(userApp.getUsername()).stream()
                                    .map(a -> annonceMapper.toAnnonceDto(a)).toList();
        }
        if (
              userApp.getRole() == Role.RECRUTEUR
        )
        {
            return annonceRepository.findAllByUserAppUsername(userApp.getUsername()).stream()
                                    .map(a -> annonceMapper.toAnnonceDto(a)).toList();
        }
        throw new ProblemException("Requete impossible pour ce role");
    }
    
    @Transactional
    public String create(Annonce annonce, UserApp recruteur) throws ProblemException
    {
        annonceValidator.validerAnnonce(annonce);
        annonce.setUserApp(recruteur);
        annonceRepository.save(annonce);
        return "annonce créée";
    }
    
    @Transactional
    public AnnonceDto addCandidatToAnnonce(Long idAnnonce, Candidature candidature, UserApp candidat) throws
          ProblemException
    {
        Annonce annonce = annonceRepository.findById(idAnnonce)
                                           .orElseThrow(() -> new ProblemException("Annonce non trouvée à cet id"));
        candidature.setAnnonce(annonce);
        candidature.setUserApp(candidat);
        
        candidatureService.create(candidature);
        return annonceMapper.toAnnonceDto(annonce);
    }
    
    @Transactional
    public void deleteById(Long idAnnonce) throws ProblemException
    {
        Annonce annonce = annonceRepository.findById(idAnnonce)
                                           .orElseThrow(() -> new ProblemException("Annonce non trouvée"));
        
        candidatureRepository.deleteAllByAnnonce(annonce);
        annonceRepository.deleteById(idAnnonce);
    }
    
    public List<CandidatureDto> getAllCandidatsById(Long idAnnonce, HttpServletRequest request) throws Exception
    {
        
        Annonce annonce = annonceRepository.findById(idAnnonce)
                                           .orElseThrow(() -> new ProblemException("Annonce non trouvée"));
        if (!annonce.getUserApp().getUsername().equals(httpUtils.getUserName(request)))
        {
            throw new ProblemException("Aucune annonce crée par cet utilisateur");
        }
        else
        {
            return annonce.getCandidatures().stream()
                          .map(candidature -> candidatureMapper.toCandidatureDto(candidature)).toList();
        }
    }
}
