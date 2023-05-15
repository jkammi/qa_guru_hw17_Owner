package guru.qa.owner;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.owner.config.ConfigReader;
import guru.qa.owner.config.ProjectConfig;
import guru.qa.owner.config.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    private static final WebDriverConfig config = ConfigReader.Instance.read();
    @BeforeAll
    static void beforeAll() {

        ProjectConfig projectConfiguration = new ProjectConfig(config);
        projectConfiguration.webDriverConfig();

    }

    @BeforeEach
    void addListener () {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments () {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}