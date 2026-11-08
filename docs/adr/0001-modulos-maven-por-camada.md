# ADR 0001: Um módulo Maven por camada da Clean Architecture

- **Status:** proposta (confirmar no Dia do Contrato)
- **Data:** 08/11/2026
- **Autores:** Grupo 1

## Contexto

O tema exige evidenciar a **direção das dependências** e a **independência das regras de
negócio** em relação à infraestrutura. Em um projeto de módulo único, a separação em camadas
depende só de disciplina: nada impede uma entidade de importar uma classe do banco.

## Decisão

Dividir o projeto em módulos Maven, um por círculo da arquitetura:
`delivery-domain`, `delivery-application`, `delivery-adapters` e `delivery-infrastructure`.
Cada módulo declara dependência apenas para o módulo imediatamente mais interno.

Além disso, o módulo `delivery-architecture-tests` usa **ArchUnit** para verificar, a cada
build, que nenhuma classe depende de uma camada mais externa e que domínio e casos de uso não
usam frameworks.

## Alternativas consideradas

| Alternativa | Por que não foi escolhida |
|---|---|
| Módulo único com pacotes por camada | A regra de dependência não é garantida pelo compilador. |
| Só ArchUnit, sem módulos | Funciona, mas não deixa a separação visível na estrutura do projeto. |
| Java Modules (JPMS) | Mais configuração, sem ganho extra para o objetivo do trabalho. |

## Consequências

- **Positivas:** uma violação da regra de dependência quebra a compilação ou o teste, o que
  serve como prova na demonstração. Cada integrante tem um módulo claro como responsabilidade.
- **Negativas / custos:** mais arquivos `pom.xml`; para executar é preciso instalar os módulos
  (`mvn install`) antes do `exec:java`.
- **Relação com a Clean Architecture:** materializa a Regra de Dependência ("o código-fonte só
  aponta para dentro") e o *Main Component* fica isolado no módulo mais externo.
