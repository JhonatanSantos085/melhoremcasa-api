package br.com.melhoremcasa.melhor_em_casa_api.controller;

import br.com.melhoremcasa.melhor_em_casa_api.model.paciente.Paciente;
import br.com.melhoremcasa.melhor_em_casa_api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> criarPaciente (@RequestBody Paciente paciente){
        Paciente novoPaciente = pacienteService.criaPaciente(paciente);
        return new ResponseEntity<>(novoPaciente, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> mostrarPacientes(){
        List<Paciente> pacientes = pacienteService.mostrarPacientes();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }
}
