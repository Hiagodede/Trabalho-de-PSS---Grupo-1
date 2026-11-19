package br.com.grupo1.delivery.domain.pedido;

import br.com.grupo1.delivery.domain.RegraDeNegocioException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/** Testes da regra Atualizar status (avançar o pedido). Dupla B. */
class PedidoAtualizarStatusTest {
    private Pedido novoPedido() {
        List<ItemPedido> itens = List.of(new ItemPedido("Pizza", 1, new BigDecimal("40.00")));
        return new Pedido("pedido-1", "restaurante-1", itens, new BigDecimal("5.00"));
    }

    @Test
    void avancaDeRecebidoParaEmPreparo() {
        //prepara
        Pedido pedido = novoPedido();
        // executa
        pedido.avancarStatus();
        // confere
        assertEquals(StatusPedido.EM_PREPARO, pedido.status());
    }

    @Test

    void avancaAteEntregueNaOrdemCerta() {

        Pedido pedido = novoPedido();

        pedido.avancarStatus();
        assertEquals(StatusPedido.EM_PREPARO, pedido.status());

        pedido.avancarStatus();
        assertEquals(StatusPedido.SAIU_PARA_ENTREGA, pedido.status());

        pedido.avancarStatus();
        assertEquals(StatusPedido.ENTREGUE, pedido.status());
    }

    @Test
    void pedidoEntregueNaoAvancaMais() {

        Pedido pedido = novoPedido();
        pedido.avancarStatus(); //EM_PREPARO
        pedido.avancarStatus(); //SAIU_PARA_ENTREGA
        pedido.avancarStatus(); //ENTREGUE

        //executa em confere: avançar de novo tem que dar erro
        assertThrows(RegraDeNegocioException.class, () -> pedido.avancarStatus());

        //e se o status não mudou
        assertEquals(StatusPedido.ENTREGUE, pedido.status());

    }

    @Test
    void pedidoCanceladoNaoAvanca() {
        Pedido pedido = novoPedido();
        pedido.cancelar();
        //executa e confere: avançar tem que dar certo
        assertThrows(RegraDeNegocioException.class, () -> pedido.avancarStatus());

        // e o status não mudou
        assertEquals(StatusPedido.CANCELADO, pedido.status());
    }
}
