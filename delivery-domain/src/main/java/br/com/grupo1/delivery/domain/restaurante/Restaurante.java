package br.com.grupo1.delivery.domain.restaurante;

import java.math.BigDecimal;

/** Restaurante que recebe os pedidos. Dupla A. */
public record Restaurante(String id, String nome, boolean aberto, BigDecimal pedidoMinimo, BigDecimal taxaDeEntrega) {

    public boolean aceitaPedidoDe(BigDecimal valorDosItens) {
        // TODO dupla A: restaurante aberto e valor acima do pedido mínimo
        throw new UnsupportedOperationException("TODO dupla A");
    }
}
