package fr.diginamic.repotp3c.mapper;

import fr.diginamic.repotp3c.dto.UserAppDto;
import fr.diginamic.repotp3c.entity.UserApp;

/**
 * user app mapper
 */
public interface IUserAppMapper
{
    /**
     * user app to dto
     * @param userApp user app
     * @return dto
     */
    UserAppDto toUserAppDto(UserApp userApp);
}
