package br.com.grupo1.delivery.application.fazerpedido;

import java.math.BigDecimal;

/** Dados que o caso de uso devolve. Dupla A. */
public record FazerPedidoSaida(String pedidoId, BigDecimal total, String status) {
}
