package io.github.andrecostan.springbootinterviewapi.rest.controller.impl;


import io.github.andrecostan.springbootinterviewapi.domain.entity.Cidade;
import io.github.andrecostan.springbootinterviewapi.helper.CidadeHelper;
import io.github.andrecostan.springbootinterviewapi.rest.controller.CidadeAPI;
import io.github.andrecostan.springbootinterviewapi.rest.dto.request.CidadeRequest;
import io.github.andrecostan.springbootinterviewapi.rest.dto.response.CidadeResponse;
import io.github.andrecostan.springbootinterviewapi.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cidades")
public class CidadeController implements CidadeAPI {

    @Autowired
    private CidadeService cidadeService;

    @Override
    public ResponseEntity buscarPorId(@PathVariable("id") Integer id) {
        Optional<Cidade> cidade = cidadeService.buscarPorId(id);
        return cidade.isPresent() ? ResponseEntity.ok(cidade) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public ResponseEntity buscarPorNome(@RequestParam("nomeCidade") String nomeCidade) {
        List<Cidade> cidades = cidadeService.buscarPorNome(nomeCidade);

        if (cidades.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade(s) não encontrada");
        }

        return ResponseEntity.ok(cidades);
    }

    @Override
    public ResponseEntity buscarCidadePorEstado(@PathVariable("nomeEstado") String nomeEstado) {
        List<Cidade> cidades = cidadeService.buscarPorEstado(nomeEstado);

        if (cidades.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade(s) não encontrada");
        }

        return ResponseEntity.ok(cidades);
    }

    @Override
    public CidadeResponse salvar(@RequestBody @Valid CidadeRequest cidadeRequest) {
        Optional<Cidade> cidade = cidadeService.salvar(cidadeRequest);
        return CidadeHelper.converterCidadeParaDTO(cidade);
    }

}
