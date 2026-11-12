package br.com.grupo1.delivery.adapters.cancelarpedido;

import br.com.grupo1.delivery.application.cancelarpedido.CancelarPedido;
import br.com.grupo1.delivery.application.cancelarpedido.CancelarPedidoEntrada;

/** Recebe o pedido do usuário, monta a entrada e chama o caso de uso. Sem regra de negócio. Dupla C. */
public class CancelarPedidoController {

    private final CancelarPedido casoDeUso;
    private final CancelarPedidoPresenter presenter;

    public CancelarPedidoController(CancelarPedido casoDeUso, CancelarPedidoPresenter presenter) {
        this.casoDeUso = casoDeUso;
        this.presenter = presenter;
    }

    public String executar(CancelarPedidoEntrada entrada) {
        // TODO dupla C: chamar o caso de uso e passar a saída para o presenter
        throw new UnsupportedOperationException("TODO dupla C");
    }
}
