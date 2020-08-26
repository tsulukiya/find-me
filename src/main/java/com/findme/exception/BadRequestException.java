package com.findme.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class BadRequestException extends HttpClientErrorException {

    public BadRequestException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }
}
