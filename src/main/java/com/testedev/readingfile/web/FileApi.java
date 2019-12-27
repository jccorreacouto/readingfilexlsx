package com.testedev.readingfile.web;

import com.testedev.readingfile.response.VencedoresResponse;
import org.springframework.http.ResponseEntity;

public interface FileApi {

    ResponseEntity<VencedoresResponse> obterVencedoresSorteio();
}
