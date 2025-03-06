package br.com.melhoremcasa.melhor_em_casa_api.repository;

import br.com.melhoremcasa.melhor_em_casa_api.model.consultoria.Consultoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConsultoriaRepository extends JpaRepository<Consultoria, Long> {
}
