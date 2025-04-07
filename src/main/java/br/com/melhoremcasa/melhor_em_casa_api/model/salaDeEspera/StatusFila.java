package br.com.melhoremcasa.melhor_em_casa_api.model.salaDeEspera;

public enum StatusFila {

    AGUARDANDO_CONTATO,
    AGUARDANDO_PRIMEIRA_VD,
    AGUARDANDO_ALTA_HOSPITALAR,


    //Status que geram inatividade do paciente

    SEM_REDE_APOIO,
    OBITO_HOSPITALAR,
    OBITO_DOMICILIAR,
    INTERNACAO_HOSPITALAR,
    ILPI,
    CANCELADO_PELO_SOLICITANTE,
    RECUSA_PACIENTE_OU_FAMILIAR,
    NOA_LOCALIZADO,
    MUDANCA_ENDERECO

}
