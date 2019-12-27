package com.testedev.readingfile.utils;

import com.testedev.readingfile.domain.enumeration.Diretorio;

import java.io.File;

public class Utils {

    private static final String HOMEPATH = Diretorio.HOMEPATH.getDiretorio();
    private static final String BARRA = File.separator;
    private static final String DIR_DOWNLOAD = Diretorio.DIR_DOWNLOAD.getDiretorio();
    private static final String DIR_PROMOCAO = Diretorio.DIR_PROMOCAO.getDiretorio();

    public static String getDiretorioEntrataVencedores() {
        return System.getProperty(HOMEPATH).concat(BARRA).concat(DIR_DOWNLOAD)
                .concat(BARRA).concat(DIR_PROMOCAO);
    }

    public static File[] getArquivos(String dirEntrada) {
        return new File(dirEntrada).listFiles();
    }

    public static boolean isFormatoValido(String nome) {
        return nome.endsWith(".csv");
    }

    public static boolean isFormatoValidoXls(String nome) {
        return nome.endsWith(".xlsx");
    }

}
