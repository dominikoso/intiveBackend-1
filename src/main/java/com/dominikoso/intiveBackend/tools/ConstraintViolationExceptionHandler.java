package com.dominikoso.intiveBackend.tools;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

public class ConstraintViolationExceptionHandler {
    public static String ValidateAndReturnExceptionResponse(ConstraintViolationException e){
        StringBuilder stringBuilder = new StringBuilder();
        for (ConstraintViolation cv:
                e.getConstraintViolations()) {
            stringBuilder.append(cv.getMessage());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
