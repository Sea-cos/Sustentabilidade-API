package br.com.futurodev.API_Sustentavel.service;


import br.com.futurodev.API_Sustentavel.model.entity.AcaoSustentavel;
import br.com.futurodev.API_Sustentavel.model.enums.CategoriaAcaoEnum;
import br.com.futurodev.API_Sustentavel.model.exceptions.ResourceNotFoundException;
import br.com.futurodev.API_Sustentavel.repository.AcaoSustentavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcaoSustentavelService {

    @Autowired
    AcaoSustentavelRepository acaoSustentavelRepository;


    public AcaoSustentavel create(AcaoSustentavel acaoSustentavel){
        return acaoSustentavelRepository.save(acaoSustentavel);
    }

    public List<AcaoSustentavel> findAcaoByCategoria(CategoriaAcaoEnum categoria) {
        return acaoSustentavelRepository.findByCategoria(categoria);
    }


    public List<AcaoSustentavel> findAllAcao(){
        return acaoSustentavelRepository.findAll();
    }


    public AcaoSustentavel findAcaoById(Long id){
        return acaoSustentavelRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Action not found with ID " + id));
    }

    public AcaoSustentavel update(Long id, AcaoSustentavel acaoSustentavelUpdate){
        AcaoSustentavel existingAcao = findAcaoById(id);
        existingAcao.setCategoria(acaoSustentavelUpdate.getCategoria());
        existingAcao.setResponsavel(acaoSustentavelUpdate.getResponsavel());
        existingAcao.setTitulo(acaoSustentavelUpdate.getTitulo());
        existingAcao.setDescricao(acaoSustentavelUpdate.getDescricao());
        existingAcao.setDataRealizacao(acaoSustentavelUpdate.getDataRealizacao());
        return acaoSustentavelRepository.save(existingAcao);
    }

    public void delete(Long id){
        AcaoSustentavel acaoSustentavel = findAcaoById(id);
        acaoSustentavelRepository.delete(acaoSustentavel);
    }

}
