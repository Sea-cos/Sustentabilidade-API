package br.com.futurodev.API_Sustentavel.repository;

import br.com.futurodev.API_Sustentavel.model.AcaoSustentavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaoSustentavelRepository extends JpaRepository<AcaoSustentavel, Long> {
}
