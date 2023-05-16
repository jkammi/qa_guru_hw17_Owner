package guru.qa.owner;


import guru.qa.owner.config.ProjectConfiguration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    public static void setUp() {
        ProjectConfiguration.configure();
    }

}