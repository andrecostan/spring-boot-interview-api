package io.github.andrecostan.springbootinterviewapi.rest.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteRespose {

    private Integer id;
    private String nome;
    private String sexo;
    private String dataNascimento;
    private Integer idade;
    @JsonProperty("cidade")
    private CidadeResponse cidadeResponse;



}

