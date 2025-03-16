package br.com.melhoremcasa.melhor_em_casa_api.controller;

import br.com.melhoremcasa.melhor_em_casa_api.model.consultoria.Consultoria;
import br.com.melhoremcasa.melhor_em_casa_api.dtos.ConsultoriaRequestDTO;
import br.com.melhoremcasa.melhor_em_casa_api.service.ConsultoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultorias")
@RequiredArgsConstructor
public class ConsultoriaController {


    private final ConsultoriaService consultoriaService;

    @PostMapping
    public ResponseEntity<Consultoria> criarConsultoria(@RequestBody ConsultoriaRequestDTO dto) {
        Consultoria novaConsultoria = consultoriaService.criarConsultoria(dto);
        return new ResponseEntity<>(novaConsultoria, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Consultoria>> mostrarConsultorias(){
        List<Consultoria> consultorias = consultoriaService.mostrarConsultorias();
        return new ResponseEntity<>(consultorias, HttpStatus.OK);
    }



}
