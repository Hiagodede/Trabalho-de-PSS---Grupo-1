/**
 * <h2>Camada de Domínio (Entities) — círculo mais interno</h2>
 *
 * <p><b>Responsável:</b> Pessoa 1 (Domínio).</p>
 *
 * <p><b>O que fica aqui:</b> as entidades do delivery e as regras de negócio que
 * valem em qualquer sistema da empresa (ex.: quais transições de status um pedido
 * pode sofrer, como o total é calculado, valores mínimos).</p>
 *
 * <p><b>Regras desta camada:</b></p>
 * <ul>
 *   <li>Java puro: nenhum import de framework, banco, web ou de outra camada do projeto.</li>
 *   <li>Regra inválida → lançar exceção de domínio, nunca devolver código de erro HTTP.</li>
 *   <li>Toda regra nova vem com teste unitário em {@code src/test}.</li>
 * </ul>
 *
 * <p>Subpacotes sugeridos: {@code model} (entidades, value objects) e
 * {@code exception} (exceções de domínio).</p>
 */
package br.com.grupo1.delivery.domain;
