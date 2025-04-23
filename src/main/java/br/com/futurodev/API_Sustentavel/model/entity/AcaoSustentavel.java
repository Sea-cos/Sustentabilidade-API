package br.com.futurodev.API_Sustentavel.model.entity;

import br.com.futurodev.API_Sustentavel.model.enums.CategoriaAcaoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class AcaoSustentavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;
    @Column
    private String descricao;
    @Column
    @Enumerated(EnumType.STRING)
    private CategoriaAcaoEnum categoria;
    @Column
    @Temporal(value = TemporalType.DATE)
    private LocalDate dataRealizacao;
    @Column
    private String responsavel;
}
