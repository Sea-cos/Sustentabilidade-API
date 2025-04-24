package br.com.futurodev.API_Sustentavel.repository;

import br.com.futurodev.API_Sustentavel.model.entity.AcaoSustentavel;
import br.com.futurodev.API_Sustentavel.model.enums.CategoriaAcaoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcaoSustentavelRepository extends JpaRepository<AcaoSustentavel, Long> {
    List<AcaoSustentavel> findByCategoria(CategoriaAcaoEnum categoria);
}
