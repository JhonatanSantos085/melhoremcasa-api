package com.hps.vilanova.repository;

import com.hps.vilanova.model.VisitaUsuario;
import com.hps.vilanova.model.VisitaUsuarioId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitaUsuarioRepository extends JpaRepository<VisitaUsuario, VisitaUsuarioId> {
}
