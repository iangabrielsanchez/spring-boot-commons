package io.github.iangabrielsanchez.springboot.commons.model;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class APIValidationError {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;

    public APIValidationError(Throwable throwable, HttpStatus httpStatus) {
        this.message = throwable.getMessage();
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timestamp = ZonedDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
