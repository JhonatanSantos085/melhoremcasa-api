package br.com.melhoremcasa.melhor_em_casa_api.model.usuario;


public enum TipoUsuario {

    ADMINISTRADOR(null),
    MOTORISTA(null);

    private final TipoEquipeID tipoEquipeID;

    TipoUsuario(TipoEquipeID tipoEquipeID) {
        this.tipoEquipeID = tipoEquipeID;
    }

    public TipoEquipeID getTipoEquipeID() {
        return tipoEquipeID;
    }

}
