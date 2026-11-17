package br.com.grupo1.delivery.domain.pedido;

import br.com.grupo1.delivery.domain.RegraDeNegocioException;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/** Regras a testar. Tire o @Disabled quando escrever cada teste. Dupla C. */
class PedidoCancelarTest {
    
    @Test
    void cancelaPedidoRecebido() {
    // prepara
    List<ItemPedido> itens = List.of(new ItemPedido("Pizza do Chefe", 1, new BigDecimal("45.00")));
    Pedido pedido = new Pedido("pedido-1", "restaurante-1", itens, new BigDecimal("8.00"));
    // executa
    pedido.cancelar();
    // confere
    assertEquals(StatusPedido.CANCELADO, pedido.status());
    }

    @Test
    @Disabled("Aguardando avancarStatus() ou proxStatus da dupla B")
    void cancelaPedidoEmPreparo() {
    // prepara
    List<ItemPedido> itens = List.of(new ItemPedido("Porção de Fritas", 1, new BigDecimal("30.00")));
    Pedido pedido = new Pedido("pedido-2", "restaurante-1", itens, new BigDecimal("8.00"));
    pedido.avancarStatus(); // RECEBIDO -> EM_PREPARO
    // executa
    pedido.cancelar();
    // confere
    assertEquals(StatusPedido.CANCELADO, pedido.status());
    }

    @Test
    @Disabled("Aguardando avancarStatus() ou proxStatus da dupla B")
    void naoCancelaDepoisDeSairParaEntrega() {
    // prepara
    List<ItemPedido> itens = List.of(new ItemPedido("Hambúrguer", 2, new BigDecimal("25.00")));
    Pedido pedido = new Pedido("pedido-3", "restaurante-1", itens, new BigDecimal("8.00"));
    pedido.avancarStatus(); // RECEBIDO -> EM_PREPARO
    pedido.avancarStatus(); // EM_PREPARO -> SAIU_PARA_ENTREGA
    // executa e confere: tem que dar erro
    assertThrows(RegraDeNegocioException.class, () -> pedido.cancelar());
    // confere: o status não mudou
    assertEquals(StatusPedido.SAIU_PARA_ENTREGA, pedido.status());
    }

    @Test
    void naoCancelaPedidoJaCancelado() {
    // prepara
    List<ItemPedido> itens = List.of(new ItemPedido("Refrigerante 2L", 1, new BigDecimal("12.00")));
    Pedido pedido = new Pedido("pedido-4", "restaurante-1", itens, new BigDecimal("8.00"));
    pedido.cancelar(); // primeira vez: funciona, vira CANCELADO
    // executa e confere: cancelar de novo tem que dar erro
    assertThrows(RegraDeNegocioException.class, () -> pedido.cancelar());
    // confere: continua CANCELADO
    assertEquals(StatusPedido.CANCELADO, pedido.status());
    }
}
