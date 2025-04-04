package com.example.ApiFilmes.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long SerialVersionUID = 1;

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }
}
