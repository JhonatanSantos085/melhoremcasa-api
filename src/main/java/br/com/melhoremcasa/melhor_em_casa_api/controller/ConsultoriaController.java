package br.com.melhoremcasa.melhor_em_casa_api.controller;

import br.com.melhoremcasa.melhor_em_casa_api.model.consultoria.Consultoria;
import br.com.melhoremcasa.melhor_em_casa_api.model.consultoria.ConsultoriaRequestDTO;
import br.com.melhoremcasa.melhor_em_casa_api.service.ConsultoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultoria")
public class ConsultoriaController {

    @Autowired
    private ConsultoriaService consultoriaService;

    @PostMapping
    public ResponseEntity<Consultoria> criarConsultoria(@RequestBody ConsultoriaRequestDTO dto) {
        Consultoria novaConsultoria = consultoriaService.criarConsultoria(dto);
        return new ResponseEntity<>(novaConsultoria, HttpStatus.CREATED);
    }



}
