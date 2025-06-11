package fr.diginamic.repotp3c.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Gestionnaire d'exceptions
 */
@ControllerAdvice
public class GlobalExceptionHandler
{
    
    @ExceptionHandler(ProblemException.class)
    public ResponseEntity<String> handleIllegalArgumentException(ProblemException e)
    {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }
}
