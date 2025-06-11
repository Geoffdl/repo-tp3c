package fr.diginamic.repotp3c.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Gestionnaire d'exceptions
 */
@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(RuntimeException.class)
    public String handleIllegalArgumentException(Exception e)
    {
        return "redirect:/view/register";
    }
    
    @ExceptionHandler(ProblemException.class)
    public String handleIllegalArgumentException(ProblemException e)
    {
        return "redirect:/view/register";
    }
}
