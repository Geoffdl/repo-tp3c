package fr.diginamic.repotp3c.validator;

import fr.diginamic.repotp3c.entity.Candidature;
import fr.diginamic.repotp3c.exception.ProblemException;
import org.springframework.stereotype.Component;

@Component
public class CandidatureValidatorImpl implements ICandidatureValidator
{
    
    @Override
    public void validerCandidature(Candidature candidature) throws ProblemException
    {
        isTrue(candidature.getLettreMotivation() != null, "La lettre de motivation ne doit pas etre nulle");
    }
}
