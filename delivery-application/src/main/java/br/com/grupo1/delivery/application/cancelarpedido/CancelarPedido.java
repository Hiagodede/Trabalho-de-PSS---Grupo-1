package br.com.grupo1.delivery.application.cancelarpedido;

/** Porta de entrada do caso de uso (o que o controller chama). Dupla C. */
public interface CancelarPedido {

    CancelarPedidoSaida executar(CancelarPedidoEntrada entrada);
}
