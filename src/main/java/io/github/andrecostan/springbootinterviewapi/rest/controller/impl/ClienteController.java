package io.github.andrecostan.springbootinterviewapi.rest.controller.impl;

import io.github.andrecostan.springbootinterviewapi.domain.entity.Cidade;
import io.github.andrecostan.springbootinterviewapi.domain.entity.Cliente;
import io.github.andrecostan.springbootinterviewapi.helper.ClienteHelper;
import io.github.andrecostan.springbootinterviewapi.rest.controller.ClienteAPI;
import io.github.andrecostan.springbootinterviewapi.rest.dto.request.ClienteAtualizarNomeRequest;
import io.github.andrecostan.springbootinterviewapi.rest.dto.request.ClienteRequest;
import io.github.andrecostan.springbootinterviewapi.rest.dto.response.ClienteRespose;
import io.github.andrecostan.springbootinterviewapi.service.CidadeService;
import io.github.andrecostan.springbootinterviewapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController implements ClienteAPI {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CidadeService cidadeService;

    @Override
    public ClienteRespose buscarPorId(@PathVariable("id") Integer id) {
        return ClienteHelper.converterClienteParaDTO(Optional.ofNullable(clienteService
                .buscarPorId(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"))));
    }

    @Override
    public List<ClienteRespose> buscarPorNome(@RequestParam("nome") String nome) {
        List<Cliente> clientes = clienteService.buscarPorNome(nome);

        if (CollectionUtils.isEmpty(clientes)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
        return ClienteHelper.converterClienteParaDTO(clientes);
    }

    @Override
    public ClienteRespose salvar(@RequestBody @Valid ClienteRequest clienteRequest) {

        Optional<Cidade> cidade = cidadeService.buscarPorId(clienteRequest.getIdCidade());
        if (!cidade.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cidade não encontrada");
        }

        Cliente cliente = ClienteHelper.converterDtoParaCliente(clienteRequest);
        cliente.setCidade(cidade.get());

        return  ClienteHelper.converterClienteParaDTO(clienteService.salvar(cliente));
    }

    @Override
    public void atualizar(@PathVariable("id") Integer id, @RequestBody @Valid ClienteAtualizarNomeRequest clienteAtualizarNomeRequest) {
        clienteService.
                buscarPorId(id)
                .map(clienteExistente -> {
                    clienteExistente.setNome(clienteAtualizarNomeRequest.getNome());
                    clienteService.atualizar(clienteExistente);
                    return clienteExistente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @Override
    public void remover(@PathVariable("id") Integer id) {
        clienteService
                .buscarPorId(id)
                .map(cliente -> {
                    clienteService.remover(cliente.getId());
                    return cliente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

}
