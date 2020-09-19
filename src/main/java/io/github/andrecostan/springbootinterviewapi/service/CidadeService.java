package io.github.andrecostan.springbootinterviewapi.service;

import io.github.andrecostan.springbootinterviewapi.domain.entity.Cidade;
import io.github.andrecostan.springbootinterviewapi.rest.dto.request.CidadeRequest;

import java.util.List;
import java.util.Optional;

public interface CidadeService {

    /**
     * Retorna uma cidade por id.
     *
     * @param id
     * @return Optional<Cidade>
     */
    Optional<Cidade> buscarPorId(Integer id);

    /**
     * Retorna uma(s) cidade(s) por nome.
     *
     * @param nome
     * @return List<Cidade>
     */
    List<Cidade> buscarPorNome(String nome);

    /**
     * Salva uma cidade na base de dados.
     *
     * @param cidadeRequest
     * @return Cidade
     */
    Optional<Cidade> salvar(CidadeRequest cidadeRequest);

    /**
     * Retorna uma lista de cidade(s) por estado.
     *
     * @param nome
     * @return List<Cidade>
     */
    List<Cidade> buscarPorEstado(String nome);
}
