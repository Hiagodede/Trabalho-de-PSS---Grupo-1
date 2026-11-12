package br.com.grupo1.delivery.application.fazerpedido;

import java.math.BigDecimal;
import java.util.List;

/** Dados que chegam ao caso de uso. Dupla A. */
public record FazerPedidoEntrada(String restauranteId, List<Item> itens) {

    public record Item(String nomeDoPrato, int quantidade, BigDecimal precoUnitario) {
    }
}
