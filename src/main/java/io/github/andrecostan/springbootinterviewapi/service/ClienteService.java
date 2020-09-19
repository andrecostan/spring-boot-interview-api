package io.github.andrecostan.springbootinterviewapi.service;

import io.github.andrecostan.springbootinterviewapi.domain.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    /**
     * Retorna um cliente por id.
     *
     * @param id
     * @return Optional<Cliente>
     */
    public Optional<Cliente> buscarPorId(Integer id);

    /**
     * Retorna um(uns) cliente(s) por nome.
     *
     * @param nome
     * @return  List<Cliente>
     */
    List<Cliente> buscarPorNome(String nome);

    /**
     * Salva um cliente na base de dados.
     *
     * @param cliente
     * @return  Optional<Cliente>
     */
    Optional<Cliente> salvar(Cliente cliente);



    Cliente atualizar(Cliente cliente);

    /**
     * Remove um cliente da base de dados.
     *
     * @param id
     */
    void remover(Integer id);
}
