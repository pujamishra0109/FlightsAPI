package com.travix.medusa.busyflights.Controller;

import com.sun.media.sound.InvalidDataException;
import com.travix.medusa.busyflights.domain.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Puja on 03/03/20.
 */
@RestControllerAdvice
@RequestMapping(produces = "application/json")
public class ExceptionResolver {
    @ExceptionHandler(Exception.class)
    public HashMap<String, String> handleException(HttpServletRequest request, Exception e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", e.getMessage());
        return response;
    }

    //@Order(Ordered.HIGHEST_PRECEDENCE)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ErrorMessage handleMissingPathVariableException(HttpServletRequest request, MissingServletRequestParameterException e) {
        ErrorMessage errorMessage=new ErrorMessage("message",e.getParameterName() +" is missing");
        return errorMessage;
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public HashMap<String, String> handleNotFoundResourceException(HttpServletRequest request, NoHandlerFoundException e) {
        HashMap<String, String> errorMessage=new HashMap<String, String>();
        errorMessage.put("message", "Requested resource wasn't found on the server");
        return errorMessage;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<HashMap<String, String>> handleIllegalArgumentException(HttpServletRequest request, NoHandlerFoundException e) {
        HashMap<String, String> errorMessage=new HashMap<String, String>();
        errorMessage.put("message", "Illegal argument Exception");
        return new ResponseEntity<HashMap<String, String>>(errorMessage,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        HashMap<String, String> errorMessage=new HashMap<String, String>();
        errorMessage.put("message", "Invalid Argument");

        return new ResponseEntity<HashMap<String, String>>(errorMessage,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationExceptions(
            ConstraintViolationException ex) {
        String exceptionResponse = String.format("Invalid input parameters: %s\n", ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


    private Map<String,String> errorMessage(HttpStatus status, Exception e) {
        String error="";
        if(status.is4xxClientError())
            error="Invalid Request";
        else if (status.is5xxServerError())
            error="Server Error";
        else
            error=status.getReasonPhrase();
        Map<String,String> errorMessage=new HashMap<>();
        errorMessage.put(error, e.getLocalizedMessage());
        return errorMessage;

    }

    @ExceptionHandler({InvalidDataException.class})
    public ResponseEntity<Map<String,String>> handleNotFoundException(InvalidDataException e) {
        return new ResponseEntity<Map<String,String>>( errorMessage(HttpStatus.BAD_REQUEST, e),HttpStatus.BAD_REQUEST);
    }


}
