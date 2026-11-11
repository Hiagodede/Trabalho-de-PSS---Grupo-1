/**
 * <h2>Camada de Adaptadores de Interface (Interface Adapters)</h2>
 *
 * <p><b>Guardião:</b> Guardião dos Adaptadores. Todas as duplas escrevem aqui na <b>onda 3</b>.</p>
 *
 * <p><b>O que fica aqui:</b> o código que converte dados entre o formato mais
 * conveniente para os casos de uso e o formato do mundo externo:</p>
 * <ul>
 *   <li><b>Controllers:</b> recebem a requisição (REST ou CLI), montam a entrada do
 *       caso de uso e o chamam.</li>
 *   <li><b>Presenters / ViewModels:</b> transformam a saída do caso de uso no que
 *       será exibido ou devolvido.</li>
 *   <li><b>Gateways:</b> implementações das portas de saída que não dependem de um
 *       framework específico (ex.: repositório em memória).</li>
 * </ul>
 *
 * <p><b>Regras desta camada:</b> pode usar casos de uso e domínio; não pode usar a
 * infraestrutura. Detalhes de framework ficam do lado de fora.</p>
 *
 * <p>Subpacotes sugeridos: {@code controller}, {@code presenter}, {@code gateway}.</p>
 */
package br.com.grupo1.delivery.adapters;
