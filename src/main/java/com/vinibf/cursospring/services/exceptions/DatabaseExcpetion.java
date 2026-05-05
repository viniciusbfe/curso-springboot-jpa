package com.vinibf.cursospring.services.exceptions;

public class DatabaseExcpetion extends RuntimeException{

    public DatabaseExcpetion(String message){
        super(message);
    }
}
