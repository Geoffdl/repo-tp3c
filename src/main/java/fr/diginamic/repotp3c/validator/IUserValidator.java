package fr.diginamic.repotp3c.validator;

import fr.diginamic.repotp3c.entity.UserApp;

public interface IUserValidator extends IValidator
{
    void validerUser(UserApp userApp);
}
