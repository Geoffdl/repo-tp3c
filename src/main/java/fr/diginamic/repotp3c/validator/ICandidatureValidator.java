package fr.diginamic.repotp3c.validator;

import fr.diginamic.repotp3c.entity.Candidature;
import fr.diginamic.repotp3c.exception.ProblemException;

/**
 * Vérifie règles métiers
 */
public interface ICandidatureValidator extends IValidator
{
    /**
     * Valide une candidature
     * @param candidature candidature
     * @throws ProblemException erreur validation
     */
    void validerCandidature(Candidature candidature) throws ProblemException;
}
