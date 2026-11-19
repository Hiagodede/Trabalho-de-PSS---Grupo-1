/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.grupo1.delivery.domain.pedido.StatePedido;

import br.com.grupo1.delivery.domain.RegraDeNegocioException;

/**
 *
 * @author Rafael
 */
public class PedidoEntregue implements EstadoPedido{
    @Override
    public EstadoPedido avancar() {
        throw new RegraDeNegocioException("O pedido já foi entregue.");
    }

    @Override
    public boolean isFinal() {
        return true;
    }
}
