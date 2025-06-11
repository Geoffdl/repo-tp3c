package fr.diginamic.repotp3c.validator;

import fr.diginamic.repotp3c.entity.Candidature;
import fr.diginamic.repotp3c.exception.ProblemException;

public interface ICandidatureValidator extends IValidator
{
    void validerCandidature(Candidature candidature) throws ProblemException;
}
