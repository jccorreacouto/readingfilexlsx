package com.testedev.readingfile.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UtilsTest {

    @Test
    public void existeDiretorioEntrada() {
        File file = new File(Utils.getDiretorioEntrataVencedores());
        Assert.assertTrue(file.isDirectory());
    }

    @Test
    public void formatoArquivoInvalido() {
        Assert.assertFalse(Utils.isFormatoValido(".dat"));
    }

}
