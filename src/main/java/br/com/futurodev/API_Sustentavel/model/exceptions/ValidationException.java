package br.com.futurodev.API_Sustentavel.model.exceptions;

public class ValidationException extends RuntimeException{
    public ValidationException(String message){
        super(message);
    }
}