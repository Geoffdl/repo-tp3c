package fr.diginamic.repotp3c.validator;

import fr.diginamic.repotp3c.entity.Annonce;
import fr.diginamic.repotp3c.exception.ProblemException;
import org.springframework.stereotype.Component;

@Component
public class AnnonceValidatorImpl implements IAnnonceValidator
{
    public void validerAnnonce(Annonce annonce) throws ProblemException
    {
        isTrue(!annonce.getDescription().isEmpty() && annonce.getDescription() != null || !annonce.getDescription()
                                                                                                  .isBlank(),
               "La description doit ne doit pas etre nulle");
    }
}
