package com.modulo10.grupo8;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MissingHeaderInfoException extends RuntimeException
{
    private static final long serialVersionUID = 1L;
 
    public MissingHeaderInfoException(String message) {
        super(message);
    }
}