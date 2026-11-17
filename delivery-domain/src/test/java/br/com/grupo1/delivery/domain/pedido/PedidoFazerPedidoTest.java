package br.com.grupo1.delivery.domain.pedido;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import br.com.grupo1.delivery.domain.RegraDeNegocioException;

/**
 * Regras a testar. Tire o @Disabled quando escrever cada teste. Dupla A.
 */
class PedidoFazerPedidoTest {

    @Test
    void totalSomaItensMaisTaxaDeEntrega() {
        ItemPedido pizza = new ItemPedido("Pizza", 2, new BigDecimal("30.00"));
        Pedido pedido = new Pedido("p1", "r1", List.of(pizza), new BigDecimal("5.00"));
        BigDecimal total = pedido.total();
        assertEquals(new BigDecimal("65.00"), total);

    }

    @Test
    void freteGratisAcimaDeCemReais() {
        ItemPedido fileComFritas = new ItemPedido("Filé com fritas", 2, new BigDecimal("100.00"));
        Pedido pedido2 = new Pedido("p2", "r2", List.of(fileComFritas), new BigDecimal("2.50"));
        BigDecimal total = pedido2.total();
        assertEquals(new BigDecimal("200.00"), total);
    }

    @Test
    void itemComQuantidadeZeroNaoAceita() {
        assertThrows(RegraDeNegocioException.class,
                () -> new ItemPedido("Pizza", 0, new BigDecimal("30.00")));

    }
}
