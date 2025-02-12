package examplespring.deb.sa.controller.advice;


import examplespring.deb.sa.dto.ErrorEntity;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ApplicationControllerAdvice {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    public @ResponseBody ErrorEntity handleException(EntityNotFoundException exception) {
        return new ErrorEntity(null, exception.getMessage());
    }





}
