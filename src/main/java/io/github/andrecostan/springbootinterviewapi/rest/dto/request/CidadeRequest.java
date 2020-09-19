package io.github.andrecostan.springbootinterviewapi.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CidadeRequest {

    @NotEmpty(message = "Campo nome é obrigatório")
    private String nome;

    @NotEmpty(message = "Campo estado é obrigatório")
    @Size(min = 2, message = "Estado inválido, no mínimo 2 caracteres")
    @Size(max = 2, message = "Estado inválido, no máximo 2 caracteres")
    private String estado;

}
