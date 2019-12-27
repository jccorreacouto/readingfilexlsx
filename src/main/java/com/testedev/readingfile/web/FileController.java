package com.testedev.readingfile.web;

import com.testedev.readingfile.domain.dto.SorteioDTO;
import com.testedev.readingfile.response.VencedoresResponse;
import com.testedev.readingfile.service.PromocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
class FileController implements FileApi {

    @Autowired
    private PromocaoService promocaoService;

    @Override
    @GetMapping("/sorteio/vencedores")
    public ResponseEntity<VencedoresResponse> obterVencedoresSorteio() {
        return ResponseEntity.ok(this.promocaoService.obterVencedoresSorteio());
    }
}
