package com.findme.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;

public class InternalServerError extends HttpServerErrorException {
    public InternalServerError(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }
}
