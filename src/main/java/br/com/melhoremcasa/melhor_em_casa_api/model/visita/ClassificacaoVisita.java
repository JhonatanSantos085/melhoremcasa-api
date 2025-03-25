package br.com.melhoremcasa.melhor_em_casa_api.model.visita;

public enum ClassificacaoVisita {
    VD_PROGRAMADA("VD Programada"),
    VD_NAO_PROGRAMADA("VD nao programada"),
    MEDICACAO_PARENTAL("Medicacao Parental"),
    POS_OBITO("Pos Obito"),
    REMOTA("Remota");


    private final String descricao;

    ClassificacaoVisita(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

}
