package br.com.futurodev.API_Sustentavel.controller;

import br.com.futurodev.API_Sustentavel.model.dtos.AcaoSustentavelRequest;
import br.com.futurodev.API_Sustentavel.model.dtos.AcaoSustentavelResponse;
import br.com.futurodev.API_Sustentavel.model.entity.AcaoSustentavel;
import br.com.futurodev.API_Sustentavel.model.enums.CategoriaAcaoEnum;
import br.com.futurodev.API_Sustentavel.service.AcaoSustentavelService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Acoes")
public class AcaoSustentavelController {

    @Autowired
    AcaoSustentavelService acaoSustentavelService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<AcaoSustentavelResponse>> list(){
        List<AcaoSustentavelResponse> acoes = this.acaoSustentavelService.findAllAcao().stream()
                .map(acao -> modelMapper.map(acao, AcaoSustentavelResponse.class)).collect(Collectors.toList());
        return acoes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(acoes);
    }

    //precisa ser apenas USER
    @GetMapping("/{id}")
    public ResponseEntity<AcaoSustentavelResponse> getById(@PathVariable Long id) {
        AcaoSustentavel acao = acaoSustentavelService.findAcaoById(id);
        if (acao == null) {
            return ResponseEntity.notFound().build();
        }
        AcaoSustentavelResponse response = modelMapper.map(acao, AcaoSustentavelResponse.class);
        return ResponseEntity.ok(response);
    }

    //precisa ser apenas USER
    @GetMapping("/categoria")
    public ResponseEntity<List<AcaoSustentavelResponse>> getByCategoria(@RequestParam String tipo) {
        try {
            // Valida o tipo recebido
            CategoriaAcaoEnum categoria = CategoriaAcaoEnum.valueOf(tipo.toUpperCase());

            List<AcaoSustentavelResponse> acoes = acaoSustentavelService.findAcaoByCategoria(categoria).stream()
                    .map(acao -> modelMapper.map(acao, AcaoSustentavelResponse.class)).collect(Collectors.toList());

            return acoes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(acoes);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }
    }

    //precisa ser apenas ADMIN
    @PostMapping
    public ResponseEntity<AcaoSustentavelResponse> create(@RequestBody @Valid AcaoSustentavelRequest acaoDTO) throws Exception{
        AcaoSustentavel acao = modelMapper.map(acaoDTO, AcaoSustentavel.class);
        AcaoSustentavel createdAcao = acaoSustentavelService.create(acao);
        AcaoSustentavelResponse createdAcaoDTO = modelMapper.map(createdAcao, AcaoSustentavelResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAcaoDTO);
    }

    //precisa ser apenas ADMIN
    @PutMapping("/{id}")
    public ResponseEntity<AcaoSustentavelResponse> update(@PathVariable Long id, @RequestBody AcaoSustentavelRequest acaoDTO) throws Exception{
        AcaoSustentavel acao = modelMapper.map(acaoDTO, AcaoSustentavel.class);
        AcaoSustentavel acaoUpdate = acaoSustentavelService.update(id, acao);
        AcaoSustentavelResponse acaoUpdateDTO = modelMapper.map(acaoUpdate, AcaoSustentavelResponse.class);
        return ResponseEntity.ok(acaoUpdateDTO);
    }

    //precisa ser apenas ADMIN
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.acaoSustentavelService.delete(id);
        return ResponseEntity.ok("Ação removida com sucesso!");
    }
}
