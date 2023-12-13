package com.zbrickx.crudemployee.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exp){
        EmployeeErrorResponse eer = new EmployeeErrorResponse();
        eer.setMessage(exp.getMessage());
        eer.setStatus(HttpStatus.NOT_FOUND.value());
        eer.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(eer,HttpStatus.NOT_FOUND);
    }

}
