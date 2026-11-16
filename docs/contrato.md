# Contrato

Combinado pelo grupo antes de programar. Mudanças só com acordo de todos.

Tema: delivery de restaurante.

## Casos de uso

| Caso de uso | O que faz | Dupla |
|---|---|---|
| Fazer pedido | Cliente escolhe pratos de um restaurante; o sistema confere se está aberto e se atingiu o pedido mínimo e calcula o total | A · Arthur e Igor |
| Atualizar status | Avança o pedido para a próxima etapa | B · Rafael e Hiago |
| Cancelar pedido | Cancela o pedido se ainda não saiu para entrega | C · Lukas e Gustavo |

## Pedido

- **Atributos:** id, restaurante, itens (prato, quantidade, preço unitário), taxa de entrega, status
- **Status possíveis:** RECEBIDO → EM_PREPARO → SAIU_PARA_ENTREGA → ENTREGUE, e CANCELADO
- **Regras:**
    - Restaurante precisa estar aberto e o pedido precisa atingir o valor mínimo
    - Total = itens + taxa de entrega; **frete grátis acima de R$ 100**
    - O status só avança na ordem, sem pular nem voltar
    - Só cancela antes de SAIU_PARA_ENTREGA

## Interfaces

O que cada caso de uso recebe, devolve e precisa salvar.

| Caso de uso | Entrada | Saída | Repositório que usa |
|---|---|---|---|
| Fazer pedido | id do restaurante + itens | id do pedido, total, status | Pedidos e Restaurantes |
| Atualizar status | id do pedido | novo status | Pedidos |
| Cancelar pedido | id do pedido | status final | Pedidos |
