package io.github.andrecostan.springbootinterviewapi.helper;

import io.github.andrecostan.springbootinterviewapi.domain.entity.Cliente;
import io.github.andrecostan.springbootinterviewapi.rest.dto.request.ClienteRequest;
import io.github.andrecostan.springbootinterviewapi.rest.dto.response.CidadeResponse;
import io.github.andrecostan.springbootinterviewapi.rest.dto.response.ClienteRespose;
import io.github.andrecostan.springbootinterviewapi.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteHelper {

    /**
     * Converte ClienteRequest para Cliente.
     *
     * @param clienteRequest
     * @return Cliente
     */
    public static Cliente converterDtoParaCliente(ClienteRequest clienteRequest) {
        Cliente cliente = Cliente
                .builder()
                .nome(clienteRequest.getNome())
                .dataNascimento(Utils.formatarData(clienteRequest.getDataNascimento(),"dd/mm/yyyy"))
                .sexo(clienteRequest.getSexo())
                .build();

        return cliente;
    }

    /**
     * Converte Cliente para ClienteRespose.
     *
     * @param cliente
     * @return ClienteRespose
     */
    public static ClienteRespose converterClienteParaDTO(Optional<Cliente> cliente) {

        CidadeResponse cidadeResponse = CidadeResponse
                .builder().id(cliente.get().getCidade().getId())
                .nome(cliente.get().getCidade().getNome())
                .estado(cliente.get().getCidade().getEstado())
                .build();

        ClienteRespose clienteRespose = ClienteRespose
                .builder()
                .id(cliente.get().getId())
                .nome(cliente.get().getNome())
                .dataNascimento(Utils.formatarData(cliente.get().getDataNascimento(), "dd/MM/yyyy"))
                .sexo(cliente.get().getSexo())
                .idade(Utils.idade(cliente.get().getDataNascimento()))
                .cidadeResponse(cidadeResponse)
                .build();

        return clienteRespose;
    }

    public static List<ClienteRespose> converterClienteParaDTO(List<Cliente> clientes) {
        List<ClienteRespose> clienteResposes = new ArrayList<ClienteRespose>();

        clientes.stream().forEach(cliente -> {

            CidadeResponse cidadeResponse = CidadeResponse
                    .builder().id(cliente.getCidade().getId())
                    .nome(cliente.getCidade().getNome())
                    .estado(cliente.getCidade().getEstado())
                    .build();

            ClienteRespose clienteRespose = ClienteRespose
                    .builder()
                    .id(cliente.getId())
                    .nome(cliente.getNome())
                    .dataNascimento(Utils.formatarData(cliente.getDataNascimento(), "dd/MM/yyyy"))
                    .sexo(cliente.getSexo())
                    .idade(Utils.idade(cliente.getDataNascimento()))
                    .cidadeResponse(cidadeResponse)
                    .build();

            clienteResposes.add(clienteRespose);
        });

        return clienteResposes;
    }
}
