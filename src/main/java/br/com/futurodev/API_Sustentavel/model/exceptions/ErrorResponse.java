package br.com.futurodev.API_Sustentavel.model.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private int  status;
    private String message;
}
