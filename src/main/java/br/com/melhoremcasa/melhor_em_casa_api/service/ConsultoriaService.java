package br.com.melhoremcasa.melhor_em_casa_api.service;

import br.com.melhoremcasa.melhor_em_casa_api.model.consultoria.Consultoria;
import br.com.melhoremcasa.melhor_em_casa_api.model.consultoria.ConsultoriaRequestDTO;
import br.com.melhoremcasa.melhor_em_casa_api.model.paciente.Paciente;
import br.com.melhoremcasa.melhor_em_casa_api.model.usuario.Usuario;
import br.com.melhoremcasa.melhor_em_casa_api.repository.ConsultoriaRepository;
import br.com.melhoremcasa.melhor_em_casa_api.repository.PacienteRepository;
import br.com.melhoremcasa.melhor_em_casa_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultoriaService {


    private final ConsultoriaRepository consultoriaRepository;


    private final PacienteRepository pacienteRepository;


    private final UsuarioRepository usuarioRepository;

    public Consultoria criarConsultoria(ConsultoriaRequestDTO dto) {
        Optional<Paciente> pacienteOpt = pacienteRepository.findById(dto.pacienteId());
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(dto.usuarioId());

        if (pacienteOpt.isEmpty() || usuarioOpt.isEmpty()) {
            throw new RuntimeException("Paciente ou Usuário não encontrado!");
        }

        var consultoria = new Consultoria();
        consultoria.setPaciente(pacienteOpt.get());
        consultoria.setUsuario(usuarioOpt.get());
        consultoria.setUnidadeSaude(dto.unidadeSaude());
        consultoria.setEquipe(dto.equipe());
        consultoria.setDataConsultoria(dto.dataConsultoria() != null ? dto.dataConsultoria() : LocalDate.now());
        consultoria.setSolicitante(dto.solicitante());

        return consultoriaRepository.save(consultoria);
    }

    public List<Consultoria> mostrarConsultorias(){
        return consultoriaRepository.findAll();
    }

    public Consultoria atualizarConsultoria (Long id, ConsultoriaRequestDTO dto){
        Optional<Consultoria> consultoriaOpt = consultoriaRepository.findById(id);
        if (consultoriaOpt.isEmpty()){
            throw new RuntimeException("consultoria nao encontrada");
        }

        var consultoria = consultoriaOpt.get();
        consultoria.setUnidadeSaude(dto.unidadeSaude());
        consultoria.setDataConsultoria(dto.dataConsultoria() != null ? dto.dataConsultoria() :
                consultoria.getDataConsultoria());
        consultoria.setSolicitante(dto.solicitante());
        consultoria.setEquipe(dto.equipe());

        return consultoriaRepository.save(consultoria);
    }

    public void deletarConsultoria(Long id){
        if (!consultoriaRepository.existsById(id)){
            throw new RuntimeException("Consultoria não encontrada");
        }else {
            consultoriaRepository.deleteById(id);
        }
    }


}
