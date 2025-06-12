package fr.diginamic.repotp3c.controller;

import fr.diginamic.repotp3c.dto.UserAppDto;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Utilisateur controller
 */
public interface IUserController
{
    /**
     * permet à un super-admin de retrouver tout les utilisateurs
     * @return list d'utilisateurs
     */
    @GetMapping({"/get-all"})
    List<UserAppDto> getAll();
}
