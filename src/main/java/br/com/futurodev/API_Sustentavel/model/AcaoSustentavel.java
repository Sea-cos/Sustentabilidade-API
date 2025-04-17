package br.com.futurodev.API_Sustentavel.model;

import br.com.futurodev.API_Sustentavel.model.enums.CategoriaAcaoEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaAcaoEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAcaoEnum categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
