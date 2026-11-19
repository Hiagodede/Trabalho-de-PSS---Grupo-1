package br.com.grupo1.delivery.adapters.repositorio;

import br.com.grupo1.delivery.application.repositorio.PedidoRepositorio;
import br.com.grupo1.delivery.domain.pedido.Pedido;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Guarda os pedidos em memória (usado nos testes e na primeira versão).
 */
public class PedidoRepositorioEmMemoria implements PedidoRepositorio {

    private final Map<String, Pedido> pedidos = new HashMap<>();

    @Override
    public void salvar(Pedido pedido) {
        pedidos.put(pedido.id(), pedido);

    }

    @Override
    public Optional<Pedido> buscarPorId(String id) {
        return Optional.ofNullable(pedidos.get(id));
    }
}
