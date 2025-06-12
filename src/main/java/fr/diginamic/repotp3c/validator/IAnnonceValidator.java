package fr.diginamic.repotp3c.validator;

import fr.diginamic.repotp3c.entity.Annonce;
import fr.diginamic.repotp3c.exception.ProblemException;

/**
 * Vérifie règles métiers
 */
public interface IAnnonceValidator extends IValidator
{
    /**
     * Valide une annonce
     * @param annonce annonce
     * @throws ProblemException erreur validation
     */
    void validerAnnonce(Annonce annonce) throws ProblemException;
}
