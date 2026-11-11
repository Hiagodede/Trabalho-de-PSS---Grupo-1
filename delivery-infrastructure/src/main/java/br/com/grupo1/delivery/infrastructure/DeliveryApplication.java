package br.com.grupo1.delivery.infrastructure;

/**
 * Ponto de entrada do sistema (Main Component da Clean Architecture).
 *
 * <p>É aqui que as dependências são "montadas" (injeção de dependência manual ou
 * via framework): cria as implementações concretas das portas de saída, entrega
 * essas implementações aos casos de uso e liga os casos de uso aos controllers.</p>
 *
 * <p>Nenhuma outra classe do sistema deve instanciar implementações concretas de
 * outra camada.</p>
 */
public final class DeliveryApplication {

    private DeliveryApplication() {
    }

    public static void main(String[] args) {
        // TODO (onda 4, revisado pelo Guardião da Infraestrutura): montar as dependências e iniciar a interface escolhida.
        System.out.println("Delivery - Clean Architecture: esqueleto pronto. Nenhum caso de uso implementado ainda.");
    }
}
