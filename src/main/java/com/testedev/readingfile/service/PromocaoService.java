package com.testedev.readingfile.service;

import com.testedev.readingfile.domain.dto.NumeroDTO;
import com.testedev.readingfile.domain.dto.SorteioDTO;
import com.testedev.readingfile.response.VencedoresResponse;
import com.testedev.readingfile.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class PromocaoService {

    public VencedoresResponse obterVencedoresSorteio() {

        List<NumeroDTO> numeros = new ArrayList<>();

        try {
                String entrada = Utils.getDiretorioEntrataVencedores();
                File[] arquivos = Utils.getArquivos(entrada);

                for (File arquivo : arquivos) {
                    if (Utils.isFormatoValidoXls(arquivo.getName())) {
                        numeros = this.tratarDadosVencedor(numeros, arquivo);
                    }

                    if(Utils.isFormatoValido(arquivo.getName())) {
                        numeros = this.tratarDadosPessoais(numeros, arquivo);
                    }
                }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<SorteioDTO> sorteios = Arrays.asList(SorteioDTO.builder().mes("Janeiro")
                                                                        .validadeInicio("2019-12-01")
                                                                        .validadeFim("2019-12-31")
                                                                        .dataSorteio("2019-01-15")
                                                                        .numeros(numeros).build());
        return VencedoresResponse.builder().response(sorteios).build();
    }

    private List<NumeroDTO> tratarDadosVencedor(List<NumeroDTO> numeros, File arquivo) throws IOException {
        FileInputStream fis = new FileInputStream(arquivo);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIt = sheet.iterator();

        while(rowIt.hasNext()) {
            NumeroDTO num = new NumeroDTO();
            String nrSerie = StringUtils.EMPTY;
            String nrSorte = StringUtils.EMPTY;
            Row row = rowIt.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch(cell.getColumnIndex()) {
                    case 0:
                        num.setVlrPremio(BigDecimal.valueOf(cell.getNumericCellValue()).longValueExact());
                        break;
                    case 1:
                    case 2:
                        if(StringUtils.isBlank(nrSerie)) {
                            nrSerie = String.valueOf(BigDecimal.valueOf(cell.getNumericCellValue()).longValueExact());
                        } else {
                            nrSorte = String.valueOf(BigDecimal.valueOf(cell.getNumericCellValue()).longValueExact());
                            num.setNumero(nrSerie.concat("/").concat(nrSorte));
                        }
                        break;
                    case 3:
                        num.setCpf(BigDecimal.valueOf(cell.getNumericCellValue()).longValueExact());
                        break;
                }
            }
            num.setPremiado(true);
            numeros.add(num);
        }
        workbook.close();
        fis.close();

        return numeros;
    }

    private List<NumeroDTO> tratarDadosPessoais(List<NumeroDTO> numeros, File arquivo) throws IOException {
        Files.lines(Paths.get(arquivo.toString())).forEach(linha -> {
            String[] dados = linha.split(",");
            Long cpf = Long.parseLong(dados[0]);
            numeros.forEach(numero -> {
                if(numero.getCpf() != null && numero.getCpf().equals(cpf)) {
                    numero.setCidade(dados[2]);
                    numero.setNome(dados[1]);
                    numero.setUf(dados[3]);
                }
            });
        });
        return numeros;
    }
}
