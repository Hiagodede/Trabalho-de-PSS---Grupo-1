package br.com.grupo1.delivery.application.repositorio;

import br.com.grupo1.delivery.domain.restaurante.Restaurante;

import java.util.Optional;

/** Interface de saída para buscar restaurantes. */
public interface RestauranteRepositorio {

    Optional<Restaurante> buscarPorId(String id);
}
