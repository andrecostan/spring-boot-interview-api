package io.github.andrecostan.springbootinterviewapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum Sexo {

    MASCULINO("M"),
    FEMININO("F");

    @Getter
    @Setter
    private String flagSexo;

}
