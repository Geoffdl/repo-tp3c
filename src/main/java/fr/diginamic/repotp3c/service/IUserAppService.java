package fr.diginamic.repotp3c.service;

import fr.diginamic.repotp3c.dto.UserAppDto;
import fr.diginamic.repotp3c.entity.Role;
import fr.diginamic.repotp3c.entity.UserApp;
import fr.diginamic.repotp3c.exception.ProblemException;
import org.springframework.http.ResponseCookie;

import java.util.List;

/**
 * User app service
 */
public interface IUserAppService
{
    /**
     * Crée un utilisateur
     * @param userApp entité jpa
     * @param role    role
     * @throws Exception exception
     */
    void createUserApp(UserApp userApp, Role role) throws Exception;
    
    /**
     * Connecte un utilisateur en lieu transmettant un cookie
     * @param userApp utilisateur
     * @return cookie contenant jwt
     * @throws Exception erreur creation cookie
     */
    ResponseCookie logUserApp(UserApp userApp) throws Exception;
    
    /**
     * Retourne un utilisateur par son identifiant
     * @param username identifiant
     * @return utilisateur
     */
    UserApp getUserApp(String username);
    
    /**
     * Retourne un utilisateur par son id
     * @param userId user id
     * @return utilisateur
     * @throws Exception id non existant
     */
    UserApp getUserAppById(Long userId) throws Exception;
    
    /**
     * Retrouve tous les utilisateurs
     * @return liste utilisateurs
     */
    List<UserAppDto> getAll();
    
    /**
     * Supprime un utilisateur
     * @param userId utilisateur
     * @throws ProblemException id non existant
     */
    void deleteUserById(Long userId) throws ProblemException;
}
