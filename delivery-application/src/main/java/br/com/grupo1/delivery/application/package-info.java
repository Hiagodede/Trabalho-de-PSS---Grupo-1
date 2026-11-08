/**
 * <h2>Camada de Casos de Uso (Application Business Rules)</h2>
 *
 * <p><b>Responsável:</b> Pessoa 2 (Casos de Uso).</p>
 *
 * <p><b>O que fica aqui:</b> os fluxos da aplicação (um caso de uso por classe), os
 * dados de entrada e saída de cada caso de uso e as <b>interfaces</b> que os casos
 * de uso precisam do mundo externo (persistência, notificação etc.).</p>
 *
 * <p><b>Ponto-chave da Regra de Dependência:</b> as interfaces de saída (ports) são
 * <i>declaradas</i> aqui, mas <i>implementadas</i> nas camadas de fora. Assim o caso
 * de uso nunca conhece o banco: é o banco que se adapta ao caso de uso.</p>
 *
 * <p><b>Regras desta camada:</b></p>
 * <ul>
 *   <li>Pode usar o domínio; não pode usar adaptadores, infraestrutura nem frameworks.</li>
 *   <li>Testes com implementações falsas (em memória) das portas de saída.</li>
 * </ul>
 *
 * <p>Subpacotes sugeridos: {@code usecase} (implementações), {@code port.in}
 * (interfaces dos casos de uso + dados de entrada/saída) e {@code port.out}
 * (interfaces para o mundo externo).</p>
 */
package br.com.grupo1.delivery.application;
