package br.com.grupo1.delivery.domain.restaurante;

import java.math.BigDecimal;

public record Restaurante(String id, String nome, boolean aberto, BigDecimal pedidoMinimo, BigDecimal taxaDeEntrega) {

    public boolean aceitaPedidoDe(BigDecimal valorDosItens) {
      return aberto && valorDosItens.compareTo(pedidoMinimo) >= 0;
    }
}
