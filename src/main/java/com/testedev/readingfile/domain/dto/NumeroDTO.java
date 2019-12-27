package com.testedev.readingfile.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class NumeroDTO {

    private String numero;
    private boolean premiado;
    private String nome;
    private String cidade;
    private String uf;
    private Long vlrPremio;

    @JsonIgnore
    private Long cpf;

}
