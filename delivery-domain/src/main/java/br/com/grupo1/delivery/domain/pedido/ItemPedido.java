package br.com.grupo1.delivery.domain.pedido;

import java.math.BigDecimal;

/** Um prato dentro do pedido. Dupla A. */
public record ItemPedido(String nomeDoPrato, int quantidade, BigDecimal precoUnitario) {

    public ItemPedido {
        // TODO dupla A: validar quantidade e preço (ex.: quantidade maior que zero)
    }

    public BigDecimal subtotal() {
        throw new UnsupportedOperationException("TODO dupla A");
    }
}
