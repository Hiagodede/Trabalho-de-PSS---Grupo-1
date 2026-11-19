package br.com.grupo1.delivery.adapters.repositorio;

import br.com.grupo1.delivery.application.repositorio.RestauranteRepositorio;
import br.com.grupo1.delivery.domain.restaurante.Restaurante;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RestauranteRepositorioEmMemoria implements RestauranteRepositorio {

    private final Map<String, Restaurante> restaurantes = new HashMap<>();

    public void adicionar(Restaurante restaurante) {
        restaurantes.put(restaurante.id(), restaurante);
    }

    @Override
    public Optional<Restaurante> buscarPorId(String id) {
        return Optional.ofNullable(restaurantes.get(id));
    }
}
