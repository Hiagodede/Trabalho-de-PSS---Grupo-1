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

<!-- TODO (Pessoa 5): atualizar esta seção quando a interface (REST/CLI) e o banco forem definidos:
     porta, endpoints ou comandos disponíveis, e como trocar a implementação de persistência. -->

## Estrutura do projeto

Cada camada da Clean Architecture é um **módulo Maven**. Um módulo só declara dependência
para módulos mais internos, então uma dependência na direção errada **não compila**.

```
infrastructure  →  adapters  →  application  →  domain
  (de fora)                                     (centro)
```

| Módulo | Camada | Responsável | Pode depender de |
|---|---|---|---|
| `delivery-domain` | Entidades | Pessoa 1 | nada |
| `delivery-application` | Casos de uso + interfaces (ports) | Pessoa 2 | domain |
| `delivery-adapters` | Controllers, presenters, gateways | Pessoa 3 | application, domain |
| `delivery-infrastructure` | Frameworks, banco, `Main` | Pessoa 4 | todos |
| `delivery-architecture-tests` | Testes da regra de dependência (ArchUnit) | Pessoa 5 | todos (só testes) |

Documentação e material da apresentação ficam em [`docs/`](docs/) (Pessoa 6):

| Pasta | Conteúdo |
|---|---|
| [`docs/contrato.md`](docs/contrato.md) | Contrato entre as camadas, definido no Dia do Contrato |
| [`docs/adr/`](docs/adr/) | Decisões técnicas e padrões de projeto adotados |
| [`docs/diagramas/`](docs/diagramas/) | Diagramas da arquitetura |
| [`docs/explicacoes/`](docs/explicacoes/) | Resumo de cada Meet de explicação |

## Integrantes

| # | Nome | Papel | GitHub |
|---|---|---|---|
| 1 | | Domínio | |
| 2 | | Casos de Uso | |
| 3 | | Adaptadores | |
| 4 | | Infraestrutura | |
| 5 | | Qualidade e Build | |
| 6 | | Arquitetura e Apresentação | |

Como contribuir: veja [`CONTRIBUTING.md`](CONTRIBUTING.md).
