package br.com.grupo1.delivery.domain.pedido;

import java.math.BigDecimal;
import br.com.grupo1.delivery.domain.RegraDeNegocioException;

public record ItemPedido(String nomeDoPrato, int quantidade, BigDecimal precoUnitario) {

    public ItemPedido {
        if (quantidade <= 0) {
            throw new RegraDeNegocioException("A quantidade de itens deve ser maior que 0.");
        } else if (precoUnitario.compareTo(BigDecimal.ZERO) < 0) {
            throw new RegraDeNegocioException("O preco nao pode ser negativo.");
        }
    }

    public BigDecimal subtotal() {
        return BigDecimal.valueOf(quantidade).multiply(precoUnitario);
    }
}
