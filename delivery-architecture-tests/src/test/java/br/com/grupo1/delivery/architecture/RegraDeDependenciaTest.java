package br.com.grupo1.delivery.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

/**
 * Verifica automaticamente a Regra de Dependência da Clean Architecture:
 * o código-fonte só pode depender de camadas MAIS INTERNAS.
 *
 * <pre>
 *   infrastructure  →  adapters  →  application  →  domain
 * </pre>
 *
 * Se algum PR violar essas regras, o build falha no CI.
 */
@AnalyzeClasses(
        packages = "br.com.grupo1.delivery",
        importOptions = ImportOption.DoNotIncludeTests.class)
class RegraDeDependenciaTest {

    private static final String DOMAIN = "br.com.grupo1.delivery.domain..";
    private static final String APPLICATION = "br.com.grupo1.delivery.application..";
    private static final String ADAPTERS = "br.com.grupo1.delivery.adapters..";
    private static final String INFRASTRUCTURE = "br.com.grupo1.delivery.infrastructure..";

    /** Pacotes de frameworks e detalhes técnicos que o núcleo não pode conhecer. */
    private static final String[] FRAMEWORKS = {
            "org.springframework..",
            "jakarta..",
            "javax.persistence..",
            "java.sql..",
            "io.javalin..",
            "com.fasterxml.jackson..",
            "org.hibernate.."
    };

    @ArchTest
    static final ArchRule dominio_nao_depende_de_nenhuma_outra_camada =
            noClasses().that().resideInAPackage(DOMAIN)
                    .should().dependOnClassesThat()
                    .resideInAnyPackage(APPLICATION, ADAPTERS, INFRASTRUCTURE)
                    .because("as entidades são o círculo mais interno e não conhecem nada de fora");

    @ArchTest
    static final ArchRule casos_de_uso_dependem_apenas_do_dominio =
            noClasses().that().resideInAPackage(APPLICATION)
                    .should().dependOnClassesThat()
                    .resideInAnyPackage(ADAPTERS, INFRASTRUCTURE)
                    .because("os casos de uso declaram interfaces (ports) em vez de usar implementações externas");

    @ArchTest
    static final ArchRule adaptadores_nao_dependem_da_infraestrutura =
            noClasses().that().resideInAPackage(ADAPTERS)
                    .should().dependOnClassesThat()
                    .resideInAPackage(INFRASTRUCTURE)
                    .because("frameworks e drivers são detalhes que ficam no círculo mais externo");

    @ArchTest
    static final ArchRule nucleo_independente_de_frameworks =
            noClasses().that().resideInAnyPackage(DOMAIN, APPLICATION)
                    .should().dependOnClassesThat()
                    .resideInAnyPackage(FRAMEWORKS)
                    .because("as regras de negócio devem ser independentes de frameworks e banco de dados");
}
