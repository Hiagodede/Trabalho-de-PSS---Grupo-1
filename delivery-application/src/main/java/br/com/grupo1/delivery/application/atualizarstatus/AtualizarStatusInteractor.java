package br.com.grupo1.delivery.application.atualizarstatus;

import br.com.grupo1.delivery.application.repositorio.PedidoRepositorio;

/** Implementação do caso de uso. Dupla B. */
public class AtualizarStatusInteractor implements AtualizarStatus {

    private final PedidoRepositorio pedidoRepositorio;

    public AtualizarStatusInteractor(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    @Override
    public AtualizarStatusSaida executar(AtualizarStatusEntrada entrada) {
        // TODO dupla B: buscar o pedido, chamar pedido.avancarStatus(), salvar e devolver a saída
        throw new UnsupportedOperationException("TODO dupla B");
    }
}
