package br.com.grupo1.delivery.adapters.repositorio;

import br.com.grupo1.delivery.application.repositorio.RestauranteRepositorio;
import br.com.grupo1.delivery.domain.restaurante.Restaurante;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/** Guarda os restaurantes em memória. Dupla A. */
public class RestauranteRepositorioEmMemoria implements RestauranteRepositorio {

    private final Map<String, Restaurante> restaurantes = new HashMap<>();

    public void adicionar(Restaurante restaurante) {
        // TODO dupla A: usado para cadastrar restaurantes de exemplo
        throw new UnsupportedOperationException("TODO dupla A");
    }

    @Override
    public Optional<Restaurante> buscarPorId(String id) {
        // TODO dupla A
        throw new UnsupportedOperationException("TODO dupla A");
    }
}
