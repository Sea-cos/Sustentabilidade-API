package br.com.futurodev.API_Sustentavel.model.exceptions;

public class AccessDeniedHandlerException extends RuntimeException {
    public AccessDeniedHandlerException(String message){
        super((message));
    }
}
