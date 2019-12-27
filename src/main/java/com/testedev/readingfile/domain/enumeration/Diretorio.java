package com.testedev.readingfile.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Diretorio {

    HOMEPATH("user.home"),
    DIR_DOWNLOAD("Downloads"),
    DIR_PROMOCAO("promocao");

    private String diretorio;

}
