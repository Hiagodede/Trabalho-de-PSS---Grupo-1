package br.com.grupo1.delivery.adapters.atualizarstatus;

import br.com.grupo1.delivery.application.atualizarstatus.AtualizarStatus;
import br.com.grupo1.delivery.application.atualizarstatus.AtualizarStatusEntrada;

/** Recebe o pedido do usuário, monta a entrada e chama o caso de uso. Sem regra de negócio. Dupla B. */
public class AtualizarStatusController {

    private final AtualizarStatus casoDeUso;
    private final AtualizarStatusPresenter presenter;

    public AtualizarStatusController(AtualizarStatus casoDeUso, AtualizarStatusPresenter presenter) {
        this.casoDeUso = casoDeUso;
        this.presenter = presenter;
    }

    public String executar(AtualizarStatusEntrada entrada) {
        // TODO dupla B: chamar o caso de uso e passar a saída para o presenter
        throw new UnsupportedOperationException("TODO dupla B");
    }
}
