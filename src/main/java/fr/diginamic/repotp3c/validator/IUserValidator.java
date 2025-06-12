package fr.diginamic.repotp3c.validator;

import fr.diginamic.repotp3c.entity.UserApp;

/**
 * Vérifie règles métiers
 */
public interface IUserValidator extends IValidator
{
    /**
     * Valide un utilisateur
     * @param userApp utilisateur
     */
    void validerUser(UserApp userApp);
}
