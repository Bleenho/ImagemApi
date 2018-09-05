package br.com.facilitando.imagem.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.facilitando.imagem.domain.ObjectNotFound;

@ControllerAdvice
public class RestExceptionHandlerAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler({ObjectNotFountException.class})
    public ResponseEntity<ObjectNotFound> handleObjectNotFoundException(ObjectNotFountException ex, WebRequest request) {
        return new ResponseEntity<>(
        		ex.getObject()
        		, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    
}
