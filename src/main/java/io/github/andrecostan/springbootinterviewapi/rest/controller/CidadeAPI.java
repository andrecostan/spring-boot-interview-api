package io.github.andrecostan.springbootinterviewapi.rest.controller;

import io.github.andrecostan.springbootinterviewapi.rest.dto.request.CidadeRequest;
import io.github.andrecostan.springbootinterviewapi.rest.dto.response.CidadeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface CidadeAPI {

    @GetMapping(path = "/{id}")
    ResponseEntity buscarPorId(@PathVariable("id") Integer id);

    @GetMapping
    ResponseEntity buscarPorNome(@RequestParam("nomeCidade") String nomeCidade);

    @GetMapping("estado/{nomeEstado}")
    ResponseEntity buscarCidadePorEstado(@PathVariable("nomeEstado") String nomeEstado);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CidadeResponse salvar(@RequestBody @Valid CidadeRequest cidadeRequest);

}
