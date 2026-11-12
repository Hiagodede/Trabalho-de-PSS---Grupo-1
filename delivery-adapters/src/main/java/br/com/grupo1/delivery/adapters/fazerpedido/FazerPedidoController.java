package br.com.grupo1.delivery.adapters.fazerpedido;

import br.com.grupo1.delivery.application.fazerpedido.FazerPedido;
import br.com.grupo1.delivery.application.fazerpedido.FazerPedidoEntrada;

/** Recebe o pedido do usuário, monta a entrada e chama o caso de uso. Sem regra de negócio. Dupla A. */
public class FazerPedidoController {

    private final FazerPedido casoDeUso;
    private final FazerPedidoPresenter presenter;

    public FazerPedidoController(FazerPedido casoDeUso, FazerPedidoPresenter presenter) {
        this.casoDeUso = casoDeUso;
        this.presenter = presenter;
    }

    public String executar(FazerPedidoEntrada entrada) {
        // TODO dupla A: chamar o caso de uso e passar a saída para o presenter
        throw new UnsupportedOperationException("TODO dupla A");
    }
}
