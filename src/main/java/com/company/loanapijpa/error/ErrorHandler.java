package com.company.loanapijpa.error;

import com.company.loanapijpa.error.dto.ErrorResponse;
import com.company.loanapijpa.error.exception.BadRequestException;
import com.company.loanapijpa.error.exception.IdentityCheckException;
import com.company.loanapijpa.error.exception.InitialCheckException;
import com.company.loanapijpa.error.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(IdentityCheckException.class)
    public ErrorResponse handleIdentityCheckException(IdentityCheckException ex) {
        return ErrorResponse.builder()
                .code(HttpStatus.CONFLICT.value())
                .message(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(InitialCheckException.class)
    public ErrorResponse handleInitialCheckException(InitialCheckException ex) {
        return ErrorResponse.builder()
                .code(HttpStatus.CONFLICT.value())
                .message(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorResponse handleBadRequestException(BadRequestException ex) {
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleNotFoundException(NotFoundException ex) {
        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();
    }

}