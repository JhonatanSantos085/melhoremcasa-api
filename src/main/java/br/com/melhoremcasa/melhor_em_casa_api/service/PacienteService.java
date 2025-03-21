package br.com.melhoremcasa.melhor_em_casa_api.service;

import br.com.melhoremcasa.melhor_em_casa_api.model.paciente.Paciente;
import br.com.melhoremcasa.melhor_em_casa_api.model.paciente.TipoPaciente;
import br.com.melhoremcasa.melhor_em_casa_api.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {


    private final PacienteRepository pacienteRepository;

    public Paciente criaPaciente(Paciente paciente){
        paciente.setTipoPaciente(TipoPaciente.INATIVO);
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> mostrarPacientes(){
        return pacienteRepository.findAll();
    }

    public Paciente atualizarPaciente(Long id, Paciente pacienteDetalhado){
        var paciente = pacienteRepository.findById(id).orElseThrow();
        paciente.setNome(pacienteDetalhado.getNome());
        return pacienteRepository.save(paciente);
    }

    public void deletarPaciente(Long id){
        var paciente = pacienteRepository.findById(id).orElseThrow();
        pacienteRepository.delete(paciente);
    }



}
