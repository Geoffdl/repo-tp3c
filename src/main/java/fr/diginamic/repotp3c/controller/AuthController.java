package fr.diginamic.repotp3c.controller;

import fr.diginamic.repotp3c.entity.Role;
import fr.diginamic.repotp3c.entity.UserApp;
import fr.diginamic.repotp3c.exception.ProblemException;
import fr.diginamic.repotp3c.service.IUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/auth"})
public class AuthController implements IAuthController
{
    @Autowired
    private IUserAppService userAppService;
    
    @PostMapping({"/create-candidat"})
    @Override
    public String createCandidat(@RequestBody UserApp candidat) throws Exception
    {
        userAppService.createUserApp(candidat, Role.CANDIDAT);
        return "candidat créé";
    }
    
    @PostMapping({"/create-recruteur"})
    @Override
    public String createRecruteur(@RequestBody UserApp recruteur) throws Exception
    {
        userAppService.createUserApp(recruteur, Role.RECRUTEUR);
        return "recruteur créé";
    }
    
    @PostMapping({"/create-admin"})
    @Override
    public String createAdmin(@RequestBody UserApp admin) throws Exception
    {
        userAppService.createUserApp(admin, Role.ADMIN);
        return "admin créé";
    }
    
    @DeleteMapping({"/delete-admin-by-id"})
    @Override
    public String deleteAdminById(@RequestParam Long id) throws ProblemException
    {
        userAppService.deleteUserById(id);
        return "administrateur supprimé";
    }
    
    @PostMapping({"/login"})
    @Override
    public ResponseEntity<?> login(@RequestBody UserApp userApp) throws Exception
    {
        return ResponseEntity.ok()
                             .header(HttpHeaders.SET_COOKIE, userAppService.logUserApp(userApp).toString())
                             .body("vous êtes connecté");
    }
}
