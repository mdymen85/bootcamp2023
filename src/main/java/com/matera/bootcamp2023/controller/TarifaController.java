package com.matera.bootcamp2023.controller;

import com.matera.bootcamp2023.domain.TipoTarifa;
import com.matera.bootcamp2023.repository.TipoTarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tarifas")
public class TarifaController {

    @Autowired
    private TipoTarifaRepository tipoTarifaRepository;

    @GetMapping
    public TipoTarifa procuraPorNome(@RequestParam String nome) {
        return tipoTarifaRepository.findByNomeContaining(nome);
    }
}