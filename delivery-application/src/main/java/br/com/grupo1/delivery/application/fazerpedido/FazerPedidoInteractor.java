package br.com.grupo1.delivery.application.fazerpedido;

import br.com.grupo1.delivery.application.repositorio.PedidoRepositorio;
import br.com.grupo1.delivery.application.repositorio.RestauranteRepositorio;

/** Implementação do caso de uso. Dupla A. */
public class FazerPedidoInteractor implements FazerPedido {

    private final PedidoRepositorio pedidoRepositorio;
    private final RestauranteRepositorio restauranteRepositorio;

    public FazerPedidoInteractor(PedidoRepositorio pedidoRepositorio, RestauranteRepositorio restauranteRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
        this.restauranteRepositorio = restauranteRepositorio;
    }

    @Override
    public FazerPedidoSaida executar(FazerPedidoEntrada entrada) {
        // TODO dupla A: buscar o restaurante, montar o Pedido, conferir as regras, salvar e devolver a saída
        throw new UnsupportedOperationException("TODO dupla A");
    }
}
