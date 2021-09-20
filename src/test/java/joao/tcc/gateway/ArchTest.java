package joao.tcc.gateway;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("joao.tcc.gateway");

        noClasses()
            .that()
            .resideInAnyPackage("joao.tcc.gateway.service..")
            .or()
            .resideInAnyPackage("joao.tcc.gateway.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..joao.tcc.gateway.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
