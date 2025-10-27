package org.todolist.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(TaskNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage(), 404));
    }

    @ExceptionHandler(InvalidTaskException.class)
    public ResponseEntity<ErrorResponse> handleInvalidTask(InvalidTaskException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage(), 400));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleUnreadable(HttpMessageNotReadableException ex) {
        // Triggers when request body is completely missing or malformed
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("Task description is required", 400));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        // Handles missing or blank "description" field
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("Task description is required");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(message, 400));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("Internal server error", 500));
    }
}
