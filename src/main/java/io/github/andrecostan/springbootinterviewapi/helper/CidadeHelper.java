package io.github.andrecostan.springbootinterviewapi.helper;

import io.github.andrecostan.springbootinterviewapi.domain.entity.Cidade;
import io.github.andrecostan.springbootinterviewapi.rest.dto.request.CidadeRequest;
import io.github.andrecostan.springbootinterviewapi.rest.dto.response.CidadeResponse;

import java.util.Optional;

public class CidadeHelper {

    /**
     * Converte CidadeRequest para Cidade.
     *
     * @param cidadeRequest
     * @return Cidade
     */
    public static Cidade converterDtoParaCidade(CidadeRequest cidadeRequest) {
        Cidade cidade = Cidade
                .builder()
                .nome(cidadeRequest.getNome())
                .estado(cidadeRequest.getEstado())
                .build();

        return cidade;
    }

    /**
     * Converte Cidade para CidadeResponse.
     *
     * @param cidade
     * @return CidadeResponse
     */
    public static CidadeResponse converterCidadeParaDTO(Optional<Cidade> cidade) {
        CidadeResponse dto = CidadeResponse
                .builder()
                .id(cidade.get().getId())
                .nome(cidade.get().getNome())
                .estado(cidade.get().getEstado())
                .build();

        return dto;
    }

}
