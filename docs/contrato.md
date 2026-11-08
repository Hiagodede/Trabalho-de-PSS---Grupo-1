# Contrato entre as camadas

> Preenchido por **todo o grupo** no Dia do Contrato.
> Depois disso, mudanças só com acordo do grupo e por PR.

**Data do acordo:** __/__/2026 · **Presentes:**

---

## 1. Estudo de caso

**Problema que o sistema resolve:**

**O que diferencia o nosso exemplo:**

## 2. Decisões de base

| Decisão | Escolha | ADR |
|---|---|---|
| Interface de entrada (REST, CLI…) | | |
| Persistência principal | | |
| Persistência alternativa (para a demonstração da troca) | | |

## 3. Casos de uso do escopo (3 a 5)

| # | Caso de uso | Ator | Resumo do fluxo | Responsável pela orquestração |
|---|---|---|---|---|
| 1 | | | | |
| 2 | | | | |
| 3 | | | | |

**Fatia vertical (primeiro a ser implementado de ponta a ponta):** caso de uso nº __

## 4. Domínio — `delivery-domain`

### Entidades e value objects

| Nome | Atributos principais | Regras / invariantes |
|---|---|---|
| | | |

### Estados e transições

| De | Para | Quem dispara | Condição |
|---|---|---|---|
| | | | |

### Exceções de domínio

| Exceção | Quando ocorre |
|---|---|
| | |

## 5. Casos de uso — `delivery-application`

Para cada caso de uso: interface, dados de entrada, dados de saída e erros possíveis.

| Caso de uso (interface) | Entrada | Saída | Erros |
|---|---|---|---|
| | | | |

### Interfaces de saída (ports) — declaradas aqui, implementadas fora

| Interface | Métodos (assinaturas) | Implementações previstas | Camada da implementação |
|---|---|---|---|
| | | | |

## 6. Adaptadores — `delivery-adapters`

| Controller / Presenter | Caso de uso que chama | Formato externo (rota, comando, JSON) |
|---|---|---|
| | | |

## 7. Infraestrutura — `delivery-infrastructure`

| Componente | Tecnologia | Implementa qual interface |
|---|---|---|
| | | |

## 8. Divisão das primeiras issues

| Issue | Camada | Responsável | Depende de |
|---|---|---|---|
| | | | |
