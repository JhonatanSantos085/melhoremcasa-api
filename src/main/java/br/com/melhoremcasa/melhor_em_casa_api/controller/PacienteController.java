package br.com.melhoremcasa.melhor_em_casa_api.controller;

import br.com.melhoremcasa.melhor_em_casa_api.model.paciente.Paciente;
import br.com.melhoremcasa.melhor_em_casa_api.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {


    private final PacienteService pacienteService;

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

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Long id, @RequestBody Paciente pacienteDetalhado){
        var pacienteAtualizado = pacienteService.atualizarPaciente(id, pacienteDetalhado);
        return new ResponseEntity<>(pacienteAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id){
        pacienteService.deletarPaciente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
