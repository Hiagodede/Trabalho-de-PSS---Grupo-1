package br.com.grupo1.delivery.domain.pedido;

import java.math.BigDecimal;
import java.util.List;

/**
 * Entidade central, compartilhada pelas três duplas.
 * Cada dupla preenche só os métodos marcados com o seu nome.
 */
public class Pedido {

    private final String id;
    private final String restauranteId;
    private final List<ItemPedido> itens;
    private final BigDecimal taxaDeEntrega;
    private StatusPedido status;

    public Pedido(String id, String restauranteId, List<ItemPedido> itens, BigDecimal taxaDeEntrega) {
        this.id = id;
        this.restauranteId = restauranteId;
        this.itens = List.copyOf(itens);
        this.taxaDeEntrega = taxaDeEntrega;
        this.status = StatusPedido.RECEBIDO;
    }

    // ---------- Dupla A: Fazer pedido ----------

    public BigDecimal total() {
        // TODO dupla A: soma dos itens + taxa de entrega (frete grátis acima de R$ 100)
        throw new UnsupportedOperationException("TODO dupla A");
    }

    // ---------- Dupla B: Atualizar status ----------

    public void avancarStatus() {
        // TODO dupla B: RECEBIDO -> EM_PREPARO -> SAIU_PARA_ENTREGA -> ENTREGUE, sem pular nem voltar
        throw new UnsupportedOperationException("TODO dupla B");
    }

    // ---------- Dupla C: Cancelar pedido ----------

    public void cancelar() {
        // TODO dupla C: só cancela antes de SAIU_PARA_ENTREGA
        throw new UnsupportedOperationException("TODO dupla C");
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
