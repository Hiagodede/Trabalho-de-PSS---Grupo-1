# Guia rápido

Explicação curta dos conceitos que usamos no projeto, para consultar enquanto programa.

## As peças, comparando com um restaurante

| Peça | No restaurante | No projeto |
|---|---|---|
| **Model** (domínio) | O pedido e o prato. Sabem calcular coisas sobre si mesmos. | `Pedido`, `ItemPedido`, `Restaurante` |
| **Repositório** | O caderno de pedidos. Só guarda e busca, não decide nada. | `PedidoRepositorio`, `RestauranteRepositorio` |
| **Interactor** (caso de uso) | O atendente. Segue os passos de uma tarefa, pedindo ajuda ao pedido e ao caderno. | `FazerPedidoInteractor`, `AtualizarStatusInteractor`, `CancelarPedidoInteractor` |
| **Controller / Presenter** | Quem recebe o cliente e quem entrega a resposta. | `...Controller`, `...Presenter` |

Resumo: **o interactor usa o repositório para buscar e guardar o model.**

## Como escrever um interactor

1. Leia o comentário `TODO` dele: os passos já estão escritos em português.
2. Veja o que **entra** (`...Entrada`) e o que **sai** (`...Saida`). Ficam na mesma pasta.
3. Use o repositório para **buscar** o que precisa.
4. Peça ao **model** para aplicar a regra (o interactor não faz conta, só coordena).
5. Use o repositório para **salvar**.
6. Devolva a `...Saida`.

Se algo der errado (pedido não existe, restaurante fechado), lance:

```java
throw new RegraDeNegocioException("mensagem explicando o motivo");
```

O `buscarPorId` devolve um `Optional`, que é uma "caixa" que pode estar vazia. Para pegar o conteúdo ou dar erro se estiver vazia:

```java
Pedido pedido = pedidoRepositorio.buscarPorId(id)
        .orElseThrow(() -> new RegraDeNegocioException("Pedido não encontrado"));
```

## Como testar um interactor: o dublê

O interactor precisa de um repositório, mas o repositório de verdade fica em outra camada. No teste, entregamos um **dublê**: uma versão simples, feita só para o teste.

```java
// Dublê do caderno de pedidos: guarda tudo num Map
static class PedidoRepositorioFalso implements PedidoRepositorio {
    Map<String, Pedido> salvos = new HashMap<>();

    public void salvar(Pedido pedido) {
        salvos.put(pedido.id(), pedido);
    }

    public Optional<Pedido> buscarPorId(String id) {
        return Optional.ofNullable(salvos.get(id));
    }
}
```

Todo teste tem 3 partes:

```java
@Test
void exemplo() {
    // 1. Prepara: cria o dublê, os objetos e o interactor
    // 2. Executa: chama casoDeUso.executar(...)
    // 3. Confere: assertEquals(esperado, resultado) ou assertThrows(...)
}
```

## Cola de Java

| Quero… | Escrevo |
|---|---|
| somar dinheiro | `a.add(b)` |
| multiplicar dinheiro | `a.multiply(b)` |
| comparar dinheiro (`a > b`) | `a.compareTo(b) > 0` |
| conferir um valor no teste | `assertEquals(esperado, resultado)` |
| conferir que dá erro | `assertThrows(RegraDeNegocioException.class, () -> codigo)` |
| import que falta | lâmpada do NetBeans → *Add import* |

Dinheiro é sempre `BigDecimal`, escrito com duas casas: `new BigDecimal("30.00")`.

## Como enviar o código

1. Atualize: **Git → Switch to Branch → `main`**, depois **Git → Remote → Pull**.
2. Crie a branch do passo: `dupla-x/nome-do-passo`.
3. Programe, rode **Test File** até passar.
4. **Commit → Push** (só a sua branch, nunca a `main`).
5. No GitHub, abra o PR com `Parte da #número-da-issue` e peça revisão a alguém de outra dupla.

Erro `release version 21 not supported`: o Maven está usando um Java antigo. Instale o JDK 21 (Temurin) e selecione-o na IDE.
