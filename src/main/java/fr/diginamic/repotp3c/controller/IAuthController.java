package fr.diginamic.repotp3c.controller;

import fr.diginamic.repotp3c.entity.UserApp;
import fr.diginamic.repotp3c.exception.ProblemException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Anthentification controller
 */
public interface IAuthController
{
    /**
     * Crée un candidat
     * @param candidat nv candidat
     * @return message confirmation
     * @throws Exception erreur d'insertion
     */
    @PostMapping({"/create-candidat"})
    String createCandidat(@RequestBody UserApp candidat) throws Exception;
    
    /**
     * Crée un recruteur
     * @param recruteur nv recruteur
     * @return message confirmation
     * @throws Exception erreur d'insertion
     */
    @PostMapping({"/create-recruteur"})
    String createRecruteur(@RequestBody UserApp recruteur) throws Exception;
    
    /**
     * Crée un admin (uniquement pour super-admin)
     * @param admin nv admin
     * @return message confirmation
     * @throws Exception erreur d'insertion
     */
    @PostMapping({"/create-admin"})
    String createAdmin(@RequestBody UserApp admin) throws Exception;
    
    /**
     * Permet à un super-admin de supprimer un admin par id
     * @param id admin id
     * @return message confirmation
     */
    @DeleteMapping({"/delete-admin-by-id"})
    String deleteAdminById(@RequestParam Long id) throws ProblemException;
    
    /**
     * Permet de se connecter
     * @param userApp nom + password + role
     * @return header avec cookie jwt
     * @throws Exception erreur login
     */
    @PostMapping({"/login"})
    ResponseEntity<?> login(@RequestBody UserApp userApp) throws Exception;
}
