package fr.diginamic.repotp3c.validator;

import fr.diginamic.repotp3c.entity.Annonce;
import fr.diginamic.repotp3c.exception.ProblemException;

public interface IAnnonceValidator extends IValidator
{
    void validerAnnonce(Annonce annonce) throws ProblemException;
}
