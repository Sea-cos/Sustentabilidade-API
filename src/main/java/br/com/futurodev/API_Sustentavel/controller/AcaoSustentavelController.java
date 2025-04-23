package br.com.futurodev.API_Sustentavel.controller;

import br.com.futurodev.API_Sustentavel.model.dtos.AcaoSustentavelRequest;
import br.com.futurodev.API_Sustentavel.model.entity.AcaoSustentavel;
import br.com.futurodev.API_Sustentavel.service.AcaoSustentavelService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Acoes")
public class AcaoSustentavelController {

    @Autowired
    AcaoSustentavelService acaoSustentavelService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<AcaoSustentavel> create(@RequestBody @Valid AcaoSustentavelRequest acaoDTO){
        AcaoSustentavel acao = modelMapper.map(acaoDTO, AcaoSustentavel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(acaoSustentavelService.create(acao));
    }
}
