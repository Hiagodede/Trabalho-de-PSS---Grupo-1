package br.com.grupo1.delivery.domain.pedido;

import br.com.grupo1.delivery.domain.RegraDeNegocioException;
import br.com.grupo1.delivery.domain.pedido.StatePedido.EstadoPedido;
import br.com.grupo1.delivery.domain.pedido.StatePedido.PedidoRecebido;
import java.math.BigDecimal;
import java.util.List;

public class Pedido {

    private final String id;
    private final String restauranteId;
    private final List<ItemPedido> itens;
    private final BigDecimal taxaDeEntrega;
    private EstadoPedido status;

    public Pedido(String id, String restauranteId, List<ItemPedido> itens, BigDecimal taxaDeEntrega) {
        this.id = id;
        this.restauranteId = restauranteId;
        this.itens = List.copyOf(itens);
        this.taxaDeEntrega = taxaDeEntrega;
        this.status = new PedidoRecebido();
    }

    // ---------- Dupla A: Fazer pedido ----------
    public BigDecimal total() {
        
        BigDecimal soma = BigDecimal.ZERO;
        for (ItemPedido item : itens) {
            soma = soma.add(item.subtotal());
        }
        if (soma.compareTo(new BigDecimal("100")) > 0) {
            return soma;
        }
        return soma.add(this.taxaDeEntrega);

    }

    // ---------- Dupla B: Atualizar status ----------
    public void avancarStatus() {
        this.status = status.avancar();
    }

    // ---------- Dupla C: Cancelar pedido ----------
    public void cancelar() {
        if (status != StatusPedido.RECEBIDO && status != StatusPedido.EM_PREPARO) {
            throw new RegraDeNegocioException("Não é possível cancelar: o pedido está " + status + ".");
        }
        this.status = StatusPedido.CANCELADO;
    }

    // ---------- Leitura (todas as duplas) ----------
    public String id() {
        return id;
    }

    public String restauranteId() {
        return restauranteId;
    }

    public List<ItemPedido> itens() {
        return itens;
    }

    public BigDecimal taxaDeEntrega() {
        return taxaDeEntrega;
    }

    public StatusPedido status() {
        return status;
    }
}
