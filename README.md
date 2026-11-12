# Delivery — Clean Architecture

Trabalho de **Projeto de Sistemas de Software** — Grupo 1, Tema 1: Clean Architecture aplicada a um
Sistema de Delivery. Sessão técnica em **01/12/2026**.

## Como executar

Pré-requisitos: **JDK 21** e **Maven 3.9+**.

```bash
git clone https://github.com/Hiagodede/Trabalho-de-PSS---Grupo-1.git
cd Trabalho-de-PSS---Grupo-1

mvn verify                                  # compila, roda os testes e checa a arquitetura
mvn install -DskipTests
mvn -pl delivery-infrastructure exec:java   # executa a aplicação
```

## Estrutura

Cada camada é um módulo Maven. Um módulo só depende dos módulos mais internos; se alguém importar
na direção errada, o build falha.

| Módulo | Camada | Depende de |
|---|---|---|
| `delivery-domain` | Entidades e regras de negócio | nada |
| `delivery-application` | Casos de uso e interfaces | domain |
| `delivery-adapters` | Controllers, presenters, gateways | application |
| `delivery-infrastructure` | Banco, framework e `Main` | adapters |
| `delivery-architecture-tests` | Teste da regra de dependência | todos |

## Como trabalhamos

3 duplas, cada uma com 1 caso de uso, programado em todas as camadas.

1. **Até 13/11:** escolher os casos de uso e combinar o Pedido ([`docs/contrato.md`](docs/contrato.md)).
2. **14 a 20/11:** cada dupla programa o seu caso de uso: domínio → caso de uso → controller → banco.
3. **21 a 26/11:** juntar, testar e fazer os diagramas.
4. **27 a 30/11:** slides e ensaios.

Regras: quem revisa o PR é alguém de outra dupla; terminou uma parte, explica na reunião semanal;
ninguém muda o Pedido sozinho.

## Integrantes

| Nome | GitHub | Dupla | Caso de uso |
|---|---|---|---|
| | | A | |
| | | A | |
| | | B | |
| | | B | |
| | | C | |
| | | C | |
