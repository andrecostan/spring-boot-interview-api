package io.github.andrecostan.springbootinterviewapi.rest.controller;

import io.github.andrecostan.springbootinterviewapi.rest.dto.request.ClienteAtualizarNomeRequest;
import io.github.andrecostan.springbootinterviewapi.rest.dto.request.ClienteRequest;
import io.github.andrecostan.springbootinterviewapi.rest.dto.response.ClienteRespose;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface ClienteAPI {

    @GetMapping(path = "/{id}")
    ClienteRespose buscarPorId(@PathVariable("id") Integer id);

    @GetMapping
    List<ClienteRespose> buscarPorNome(@RequestParam("nome") String nome);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ClienteRespose salvar(@RequestBody @Valid ClienteRequest clienteRequest);

    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void atualizar(@PathVariable("id") Integer id, @RequestBody @Valid ClienteAtualizarNomeRequest clienteAtualizarNomeRequest);

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void remover(@PathVariable("id") Integer id);

}
