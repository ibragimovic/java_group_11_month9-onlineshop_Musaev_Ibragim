package edu.attractor.onlineshop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import static java.util.stream.Collectors.toList;

@ControllerAdvice(annotations = RestController.class)
public class BindExceptionHandler {

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<Object> handleBindException(BindException ex) {
        var bindingResult = ex.getBindingResult();

        var apiFieldErrors = bindingResult
                .getFieldErrors()
                .stream()
                .map(fieldError -> String.format("%s -> %s", fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(toList());

        return ResponseEntity.unprocessableEntity().body(apiFieldErrors);
    }

}
