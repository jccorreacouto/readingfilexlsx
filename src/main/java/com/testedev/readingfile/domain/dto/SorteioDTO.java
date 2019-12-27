package com.testedev.readingfile.domain.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SorteioDTO {

    private String mes;
    private String validadeInicio;
    private String validadeFim;
    private String dataSorteio;
    private List<NumeroDTO> numeros;

}
