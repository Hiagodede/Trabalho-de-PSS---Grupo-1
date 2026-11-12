package br.com.grupo1.delivery.infrastructure.terminal;

import br.com.grupo1.delivery.adapters.atualizarstatus.AtualizarStatusController;
import br.com.grupo1.delivery.adapters.cancelarpedido.CancelarPedidoController;
import br.com.grupo1.delivery.adapters.fazerpedido.FazerPedidoController;

import java.util.Scanner;

/**
 * Menu do terminal: lê o que o usuário digita e chama o controller certo.
 * Cada dupla escreve a opção do seu caso de uso.
 */
public class MenuTerminal {

    private final FazerPedidoController fazerPedido;
    private final AtualizarStatusController atualizarStatus;
    private final CancelarPedidoController cancelarPedido;

    public MenuTerminal(FazerPedidoController fazerPedido,
                        AtualizarStatusController atualizarStatus,
                        CancelarPedidoController cancelarPedido) {
        this.fazerPedido = fazerPedido;
        this.atualizarStatus = atualizarStatus;
        this.cancelarPedido = cancelarPedido;
    }

    public void iniciar() {
        Scanner entrada = new Scanner(System.in);
        // TODO: laço do menu
        //   1 - Fazer pedido      -> dupla A
        //   2 - Atualizar status  -> dupla B
        //   3 - Cancelar pedido   -> dupla C
        //   0 - Sair
        throw new UnsupportedOperationException("TODO menu");
    }
}
