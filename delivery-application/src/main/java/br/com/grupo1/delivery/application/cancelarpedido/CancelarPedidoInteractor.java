package br.com.grupo1.delivery.application.cancelarpedido;

import br.com.grupo1.delivery.application.repositorio.PedidoRepositorio;

/** Implementação do caso de uso. Dupla C. */
public class CancelarPedidoInteractor implements CancelarPedido {

    private final PedidoRepositorio pedidoRepositorio;

    public CancelarPedidoInteractor(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    @Override
    public CancelarPedidoSaida executar(CancelarPedidoEntrada entrada) {
        // TODO dupla C: buscar o pedido, chamar pedido.cancelar(), salvar e devolver a saída
        throw new UnsupportedOperationException("TODO dupla C");
    }
}
