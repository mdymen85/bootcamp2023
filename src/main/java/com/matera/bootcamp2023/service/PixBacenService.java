package com.matera.bootcamp2023.service;

import com.matera.bootcamp2023.dto.PixBacenDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class PixBacenService {

    private static final String CONTAS_BACEN_URL = "http://localhost:8081/v1/contas";

    private final static RestTemplate restTemplate = new RestTemplate();

    public void cadastraPixBancoCentral(PixBacenDto pixBacenDTO) {
        HttpEntity<PixBacenDto> request = new HttpEntity<>(pixBacenDTO);
        PixBacenDto pixBacenDto = restTemplate.postForObject(CONTAS_BACEN_URL,
                request, PixBacenDto.class);
        log.info("Conta cadastrada com sucesso no BACEN: {}", pixBacenDto);
    }

    public PixBacenDto buscarContaBancoCentral(String chavePix) {
        String url = String.format("%s/%s", CONTAS_BACEN_URL, chavePix);
        PixBacenDto pixBacenDto = restTemplate.getForObject(url, PixBacenDto.class);
        log.info("Conta encontrada com sucesso no BACEN: {}", pixBacenDto);
        return pixBacenDto;
    }

}