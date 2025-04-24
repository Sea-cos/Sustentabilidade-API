package br.com.futurodev.API_Sustentavel.model.exceptions;

public class ConflictException extends RuntimeException{
    public ConflictException(String message){
        super(message);
    }
}