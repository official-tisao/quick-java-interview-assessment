package com.assessment.saheed.exception;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(JsonMappingException.class)
    @ResponseBody
    public ResponseEntity<Void> handleBadProp1(JsonMappingException ex) {
        System.out.println(ex.getMessage());
        ex.printStackTrace();
        return ResponseEntity.status(422).build();
    }
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ResponseEntity<Void> handleBadProp2(NullPointerException ex) {
        System.out.println(ex.getMessage());
        ex.printStackTrace();
        return ResponseEntity.status(422).build();
    }

    @ExceptionHandler(JsonParseException.class)
    @ResponseBody
    public ResponseEntity<Void> handleBadJSON(JsonParseException ex) {
        System.out.println(ex.getMessage());
        ex.printStackTrace();
        return ResponseEntity.status(400).build();
    }
}
