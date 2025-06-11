package fr.diginamic.repotp3c.mapper;

import fr.diginamic.repotp3c.dto.UserAppDto;
import fr.diginamic.repotp3c.entity.UserApp;
import org.springframework.stereotype.Component;

@Component
public class UserAppMapper
{
    public UserAppDto toUserAppDto(UserApp userApp)
    {
        
        UserAppDto dto = new UserAppDto();
        dto.setId(userApp.getId());
        dto.setUsername(userApp.getUsername());
        dto.setRole(userApp.getRole().toString());
        
        return dto;
    }
}
