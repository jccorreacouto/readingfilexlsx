package com.testedev.readingfile.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PromocaoServiceTest {

    @MockBean
    private PromocaoService service;

    @Test
    public void checkMethodObterVencedoresSorteio() {
        service.obterVencedoresSorteio();
    }
}
