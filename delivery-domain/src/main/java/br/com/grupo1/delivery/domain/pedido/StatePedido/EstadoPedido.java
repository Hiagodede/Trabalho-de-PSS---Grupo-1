/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.grupo1.delivery.domain.pedido.StatePedido;

/**
 *
 * @author Rafael
 */
public interface EstadoPedido {
    
    EstadoPedido avancar();
    boolean isFinal();
}
