package br.com.grupo1.delivery.application.fazerpedido;

/** Porta de entrada do caso de uso (o que o controller chama). Dupla A. */
public interface FazerPedido {

    FazerPedidoSaida executar(FazerPedidoEntrada entrada);
}
