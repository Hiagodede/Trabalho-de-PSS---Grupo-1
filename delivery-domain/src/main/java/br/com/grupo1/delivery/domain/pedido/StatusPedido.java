package br.com.grupo1.delivery.domain.pedido;

import java.util.Optional;

/** Estados possíveis de um pedido. */
public enum StatusPedido {

    RECEBIDO,
    EM_PREPARO,
    SAIU_PARA_ENTREGA,
    ENTREGUE,
    CANCELADO;

    public Optional<StatusPedido> proximo() {
        return switch (this) {
            case RECEBIDO          -> Optional.of(EM_PREPARO);
            case EM_PREPARO        -> Optional.of(SAIU_PARA_ENTREGA);
            case SAIU_PARA_ENTREGA -> Optional.of(ENTREGUE);
            case ENTREGUE, CANCELADO -> Optional.empty();
        };
    }

    public boolean StatusFinal() {
        return proximo().isEmpty();
    }
}