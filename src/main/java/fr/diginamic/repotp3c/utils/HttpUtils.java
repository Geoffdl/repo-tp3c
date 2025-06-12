package fr.diginamic.repotp3c.utils;

import fr.diginamic.repotp3c.entity.UserApp;
import fr.diginamic.repotp3c.service.IJwtAuthentificationService;
import fr.diginamic.repotp3c.service.UserAppService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HttpUtils
{
    @Autowired
    UserAppService userAppService;
    @Autowired
    IJwtAuthentificationService IJwtAuthentificationService;
    
    public String getUserName(HttpServletRequest request) throws Exception
    {
        return userAppService.getUserApp(IJwtAuthentificationService.getUsernameFromCookie(request))
                             .getUsername();
    }
    
    public UserApp getUserApp(HttpServletRequest request) throws Exception
    {
        return userAppService.getUserApp(IJwtAuthentificationService.getUsernameFromCookie(request));
    }
    
    public String getUserRole(HttpServletRequest request) throws Exception
    {
        return userAppService.getUserApp(IJwtAuthentificationService.getUsernameFromCookie(request))
                             .getRole().toString();
    }
}
