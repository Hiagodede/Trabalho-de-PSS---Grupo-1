package br.com.grupo1.delivery.application.repositorio;

import br.com.grupo1.delivery.domain.pedido.Pedido;

import java.util.Optional;

/** Interface de saída: o caso de uso declara, a camada de fora implementa. */
public interface PedidoRepositorio {

    void salvar(Pedido pedido);

    Optional<Pedido> buscarPorId(String id);
}
