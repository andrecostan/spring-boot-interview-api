package io.github.andrecostan.springbootinterviewapi.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    @NotEmpty(message = "Campo nome é obrigatório.")
    private String nome;

    @NotEmpty(message = "Campo sexo é obrigatório.")
    private String sexo;

    @NotEmpty(message = "Campo dataNascimento é obrigatório.")
    private String dataNascimento;

    @NotNull(message = "Campo idCidade é obrigatório.")
    private Integer idCidade;

}
