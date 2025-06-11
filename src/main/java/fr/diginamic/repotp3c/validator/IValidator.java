package fr.diginamic.repotp3c.validator;

import fr.diginamic.repotp3c.exception.ProblemException;

/**
 * Interface de validation de donnée
 */
public interface IValidator
{
    /**
     * Test de validation, le test en parametre doit etre valide, sinon la methode jette une exception
     * @param condition    test valide à confirmer
     * @param errorMessage message d'erreur le cas échéant
     * @throws ProblemException le test a échoué
     */
    default void isTrue(boolean condition, String errorMessage) throws ProblemException
    {
        if (!condition)
        {
            throw new ProblemException(errorMessage);
        }
    }
}
