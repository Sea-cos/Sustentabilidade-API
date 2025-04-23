package br.com.futurodev.API_Sustentavel.model.dtos;

import br.com.futurodev.API_Sustentavel.model.enums.CategoriaAcaoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcaoSustentavelRequest {

        @NotBlank(message = "Titulo obrigatório.")
        @Size(max = 45, message = "Limite de 45 caracteres")
        private String titulo;

        @NotBlank(message = "Descrição obrigatório.")
        private String descricao;

        private CategoriaAcaoEnum categoria;

        @PastOrPresent(message = "A data deve ser no passado ou no presente.")
        private LocalDate dataRealizacao;

        @NotBlank(message = "Responsavel é obrigatório.")
        private String responsavel;
}
