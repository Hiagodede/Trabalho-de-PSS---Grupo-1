package br.com.grupo1.delivery.domain.pedido;

/** Estados possíveis de um pedido. */
public enum StatusPedido {
    RECEBIDO,
    EM_PREPARO,
    SAIU_PARA_ENTREGA,
    ENTREGUE,
    CANCELADO
}
