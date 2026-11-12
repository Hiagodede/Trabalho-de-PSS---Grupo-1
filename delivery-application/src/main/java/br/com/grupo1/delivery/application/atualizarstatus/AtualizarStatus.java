package br.com.grupo1.delivery.application.atualizarstatus;

/** Porta de entrada do caso de uso (o que o controller chama). Dupla B. */
public interface AtualizarStatus {

    AtualizarStatusSaida executar(AtualizarStatusEntrada entrada);
}
