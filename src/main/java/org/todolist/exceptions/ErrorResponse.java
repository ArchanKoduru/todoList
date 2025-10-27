package org.todolist.exceptions;

public record ErrorResponse(String message, int status) {}