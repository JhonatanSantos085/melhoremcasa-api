package com.hps.vilanova.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisitaUsuario {

    @EmbeddedId
    private VisitaUsuarioId id;


 @ManyToOne
 @MapsId("visitaId")
 private Visita visita;

 @ManyToOne
 @MapsId("usuarioId")
 private Usuario usuario;
}
