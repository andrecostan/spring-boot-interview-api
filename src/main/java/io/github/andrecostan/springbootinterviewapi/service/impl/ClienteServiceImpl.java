package io.github.andrecostan.springbootinterviewapi.service.impl;

import io.github.andrecostan.springbootinterviewapi.domain.entity.Cliente;
import io.github.andrecostan.springbootinterviewapi.domain.repository.ClienteRepository;
import io.github.andrecostan.springbootinterviewapi.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Optional<Cliente> buscarPorId(Integer id) {
        log.info("Buscando cliente para o id: {}", id);
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> buscarPorNome(String nome) {
        log.info("Buscando cliente(s) para o nome: {}", nome);
        return clienteRepository.findAllByNome(nome);
    }

    @Override
    public Optional<Cliente> salvar(Cliente cliente) {
        log.info("Salvando cliente: {}", cliente);
        return Optional.ofNullable(clienteRepository.save(cliente));
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        log.info("Atualizando cliente: {}", cliente);
        return clienteRepository.save(cliente);
    }

    @Override
    public void remover(Integer id) {
        log.info("Removendo cliente com id: {}", id);
        clienteRepository.deleteById(id);
    }

}
