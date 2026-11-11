# Delivery — Clean Architecture

Trabalho da disciplina de **Projeto de Sistemas de Software** — Grupo 1, **Tema 1**:
*Clean Architecture com exemplo em Java aplicado a um Sistema de Delivery, evidenciando a
separação de responsabilidades, a direção das dependências e a independência das regras de
negócio em relação à infraestrutura.*

> Sessão técnica: **01/12/2026**, Laboratório 3.

## Pré-requisitos

| Ferramenta | Versão | Como conferir |
|---|---|---|
| JDK | 21 | `java -version` |
| Apache Maven | 3.9 ou superior | `mvn -version` |
| Git | qualquer recente | `git --version` |

Nenhuma IDE é necessária: todos os comandos abaixo rodam no terminal.

## Como executar localmente

```bash
# 1. Clonar
git clone https://github.com/Hiagodede/Trabalho-de-PSS---Grupo-1.git
cd Trabalho-de-PSS---Grupo-1

# 2. Compilar, rodar todos os testes e verificar a regra de dependência
mvn verify

# 3. Executar a aplicação
mvn install -DskipTests
mvn -pl delivery-infrastructure exec:java
```

<!-- TODO (função Qualidade e Build): atualizar esta seção quando a interface (REST/CLI) e o banco forem definidos:
     porta, endpoints ou comandos disponíveis, e como trocar a implementação de persistência. -->

## Estrutura do projeto

Cada camada da Clean Architecture é um **módulo Maven**. Um módulo só declara dependência
para módulos mais internos, então uma dependência na direção errada **não compila**.

Todas as duplas escrevem código em todas as camadas (veja [Como o grupo trabalha](#como-o-grupo-trabalha)).
O **guardião** de uma camada não a escreve sozinho: ele revisa os PRs dela e garante que o código
fique consistente entre as duplas.

```
infrastructure  →  adapters  →  application  →  domain
  (de fora)                                     (centro)
```

| Módulo | Camada | Onda | Guardião | Pode depender de |
|---|---|---|---|---|
| `delivery-domain` | Entidades | 1 | Guardião do Domínio | nada |
| `delivery-application` | Casos de uso + interfaces (ports) | 2 | Guardião dos Casos de Uso | domain |
| `delivery-adapters` | Controllers, presenters, gateways | 3 | Guardião dos Adaptadores | application, domain |
| `delivery-infrastructure` | Frameworks, banco, `Main` | 4 | Guardião da Infraestrutura | todos |
| `delivery-architecture-tests` | Testes da regra de dependência (ArchUnit) | — | Qualidade e Build | todos (só testes) |

Documentação e material da apresentação ficam em [`docs/`](docs/) (função Arquitetura e Apresentação):

| Pasta | Conteúdo |
|---|---|
| [`docs/contrato.md`](docs/contrato.md) | Contrato entre as camadas, definido no Dia do Contrato |
| [`docs/adr/`](docs/adr/) | Decisões técnicas e padrões de projeto adotados |
| [`docs/diagramas/`](docs/diagramas/) | Diagramas da arquitetura |
| [`docs/explicacoes/`](docs/explicacoes/) | Resumo de cada Meet de explicação |

## Como o grupo trabalha

O grupo trabalha em **3 duplas**, e cada dupla é dona de 1 ou 2 casos de uso em **todas** as camadas.
As duplas avançam juntas, uma camada por vez, **de dentro para fora**, seguindo a regra de dependência:

| Onda | Datas | Todas as duplas trabalham em |
|---|---|---|
| 1 | 14–15/11 | Domínio: entidades e regras do seu caso de uso |
| 2 | 16–17/11 | Casos de uso e interfaces (ports), testados com repositório em memória |
| 3 | 18/11 | Adaptadores: controller, presenter e DTOs |
| 4 | 19/11 | Infraestrutura: persistência real que implementa as interfaces da onda 2 |
| — | 20/11 | Integração e revisão |

No fim de cada onda, cada dupla explica o que fez para o grupo (resumo em [`docs/explicacoes/`](docs/explicacoes/)).
A entidade central (Pedido) e as interfaces são definidas juntas em [`docs/contrato.md`](docs/contrato.md).

## Integrantes

| Nome | GitHub | Dupla | Função transversal | Casos de uso |
|---|---|---|---|---|
| | | A | | |
| | | A | | |
| | | B | | |
| | | B | | |
| | | C | | |
| | | C | | |

Funções transversais: Guardião do Domínio, Guardião dos Casos de Uso, Guardião dos Adaptadores,
Guardião da Infraestrutura, Qualidade e Build, Arquitetura e Apresentação.

Como contribuir: veja [`CONTRIBUTING.md`](CONTRIBUTING.md).
