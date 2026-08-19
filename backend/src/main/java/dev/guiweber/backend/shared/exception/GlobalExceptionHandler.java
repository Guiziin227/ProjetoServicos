package dev.guiweber.backend.shared.exception;

import dev.guiweber.backend.clientes.domain.exceptions.ClienteEmailAlreadyExistsException;
import dev.guiweber.backend.clientes.domain.exceptions.ClienteNotFoundException;
import dev.guiweber.backend.clientes.domain.exceptions.ClienteTelefoneAlreadyExistsException;
import dev.guiweber.backend.servicos.domain.exceptions.ServicoNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            ClienteEmailAlreadyExistsException.class,
            ClienteTelefoneAlreadyExistsException.class
    })
    public ResponseEntity<ApiErrorResponse> handleClienteConflict(
            RuntimeException exception,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.CONFLICT;

        ApiErrorResponse response = new ApiErrorResponse(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler({ClienteNotFoundException.class,
            ServicoNotFoundException.class})
    public ResponseEntity<ApiErrorResponse> handleClienteNotFound(
            Exception exception,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        ApiErrorResponse response = new ApiErrorResponse(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGenericException(
            Exception exception,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ApiErrorResponse response = new ApiErrorResponse(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(response);
    }
}
