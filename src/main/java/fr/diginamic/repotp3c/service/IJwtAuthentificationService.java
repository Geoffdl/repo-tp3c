package fr.diginamic.repotp3c.service;

import fr.diginamic.repotp3c.entity.UserApp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseCookie;

/**
 * JWT manager service
 */
public interface IJwtAuthentificationService
{
    /**
     * Génère un token jwt pour l'utilisateur
     * @param userApp utilisateur
     * @return token jwt
     */
    ResponseCookie generateToken(UserApp userApp);
    
    /**
     * Retrouve le sujet du token
     * @param token token jwt
     * @return sujet
     */
    String getSubject(String token);
    
    /**
     * Retrouve le nom d'utilisateur via le cookie
     * @param request request avec utilisateur authentifié
     * @return nom d'utilisateur
     * @throws Exception erreur de parsing
     */
    String getUsernameFromCookie(HttpServletRequest request) throws Exception;
    
    /**
     * Confirme la validité du token
     * @param token token jwt
     * @return true/false
     */
    Boolean validateToken(String token);
}
