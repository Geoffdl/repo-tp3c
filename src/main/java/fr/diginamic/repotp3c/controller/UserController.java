package fr.diginamic.repotp3c.controller;

import fr.diginamic.repotp3c.dto.UserAppDto;
import fr.diginamic.repotp3c.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/user"})
public class UserController
{
    @Autowired
    private UserAppService userAppService;
    
    @GetMapping({"/get-all"})
    public List<UserAppDto> getAll()
    {
        return userAppService.getAll();
    }
}
