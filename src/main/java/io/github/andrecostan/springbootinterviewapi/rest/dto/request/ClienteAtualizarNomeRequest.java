package io.github.andrecostan.springbootinterviewapi.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteAtualizarNomeRequest {

    @NotEmpty(message = "Campo nome é obrigatório.")
    private String nome;

}
