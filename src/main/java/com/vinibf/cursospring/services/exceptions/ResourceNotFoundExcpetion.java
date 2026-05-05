package com.vinibf.cursospring.services.exceptions;

public class ResourceNotFoundExcpetion extends RuntimeException {

    public ResourceNotFoundExcpetion(Object id) {
        super("Resource not found. Id " + id);
    }
}
