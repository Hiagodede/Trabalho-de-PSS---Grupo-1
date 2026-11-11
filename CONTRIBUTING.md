# Como trabalhamos

## Fluxo de uma tarefa

1. Pegue uma **issue** no quadro (GitHub Projects) e coloque seu nome nela.
2. Crie uma branch a partir da `main`:
   ```bash
   git switch main && git pull
   git switch -c <camada>/<descricao-curta>
   ```
   Formato: `<camada>/<caso-de-uso>-<descricao>`. Prefixos de camada: `dominio/`, `casos-de-uso/`,
   `adaptadores/`, `infra/`, `build/`, `docs/`.
   Exemplo: `dominio/realizar-pedido-status`.
3. Faça commits pequenos, com mensagens no imperativo:
   `Adiciona transições de status do Pedido`.
4. Antes de abrir o PR, rode `mvn verify` localmente.
5. Abra o PR, preencha o template e peça revisão para **alguém de outra dupla**,
   de preferência o guardião da camada (se ele for da sua dupla, outra pessoa revisa).
6. Depois do merge, mova a issue para *Feito*.

## Definição de Pronto

Uma tarefa só está pronta quando:

- [ ] o `mvn verify` passa, incluindo o teste da regra de dependência;
- [ ] o comportamento novo tem testes;
- [ ] o PR foi aprovado por alguém de outra dupla;
- [ ] se ela fecha uma parte: aconteceu o Meet de explicação e o resumo está em `docs/explicacoes/`.

## Duplas e ondas

Cada dupla é dona de 1 ou 2 casos de uso em todas as camadas. Todas as duplas trabalham na mesma
camada ao mesmo tempo, de dentro para fora: domínio → casos de uso → adaptadores → infraestrutura.

- Numa onda, só se mexe na camada daquela onda (ou nas de dentro, por mudança de contrato).
- Se precisar de algo de uma camada externa que ainda não existe, use uma implementação falsa
  da interface (ex.: repositório em memória). Nunca espere a camada de fora.
- No fim de cada onda, cada dupla explica o que fez no Meet do grupo.

## Contratos

As interfaces combinadas no Dia do Contrato ficam em [`docs/contrato.md`](docs/contrato.md).
**Não altere um contrato sozinho:** avise o grupo, combinem a mudança e atualizem o documento
no mesmo PR.

## Decisões técnicas

Toda decisão relevante (padrão de projeto, biblioteca, formato da API) vira um ADR em
[`docs/adr/`](docs/adr/), usando o [modelo](docs/adr/0000-modelo.md). Esses registros viram o
slide de *Decisões Técnicas*.

## Regras da arquitetura (o CI verifica)

- `domain` não importa nada de outra camada nem de frameworks.
- `application` só importa `domain`; as interfaces de saída são **declaradas** aqui.
- `adapters` não importa `infrastructure`.
- Frameworks, banco e a classe `Main` ficam só em `infrastructure`.
