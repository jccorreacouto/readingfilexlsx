package com.testedev.readingfile.response;

import com.testedev.readingfile.domain.dto.SorteioDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VencedoresResponse {

    private List<SorteioDTO> response;
}
