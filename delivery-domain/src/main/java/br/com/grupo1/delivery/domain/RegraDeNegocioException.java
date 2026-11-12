package br.com.grupo1.delivery.domain;

/** Lançada quando uma regra do negócio é violada (ex.: cancelar pedido já entregue). */
public class RegraDeNegocioException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RegraDeNegocioException(String mensagem) {
        super(mensagem);
    }
}
