package br.com.futurodev.API_Sustentavel.model.dtos;


import br.com.futurodev.API_Sustentavel.model.enums.CategoriaAcaoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcaoSustentavelResponse{
        private Long id;
        private String titulo;
        private String descricao;
        private CategoriaAcaoEnum categoria;
        private LocalDate dataRealizacao;
        private String responsavel;
}
