package io.github.andrecostan.springbootinterviewapi.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CidadeResponse {

    private Integer id;
    private String nome;
    private String estado;

}
