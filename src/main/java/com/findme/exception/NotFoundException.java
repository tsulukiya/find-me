package com.findme.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class NotFoundException extends HttpClientErrorException {
    public NotFoundException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }
}
