/**
 * <h2>Camada de Frameworks e Drivers (Infraestrutura) — círculo mais externo</h2>
 *
 * <p><b>Responsável:</b> Pessoa 4 (Infraestrutura).</p>
 *
 * <p><b>O que fica aqui:</b> tudo o que é "detalhe" segundo a Clean Architecture:</p>
 * <ul>
 *   <li>Framework web ou interface de linha de comando.</li>
 *   <li>Acesso real a banco de dados (JDBC, driver, scripts de criação).</li>
 *   <li>Configuração e a classe {@link br.com.grupo1.delivery.infrastructure.DeliveryApplication},
 *       o <i>Main Component</i>: o único lugar que conhece todas as classes concretas e
 *       as conecta.</li>
 * </ul>
 *
 * <p><b>Objetivo para a demonstração:</b> trocar a implementação de uma porta de
 * saída (ex.: memória → banco) alterando só esta camada.</p>
 */
package br.com.grupo1.delivery.infrastructure;
