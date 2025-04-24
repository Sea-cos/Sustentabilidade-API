package br.com.futurodev.API_Sustentavel.model.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
