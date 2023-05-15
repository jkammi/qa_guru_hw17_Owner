package guru.qa.owner.config;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static guru.qa.owner.data.Browser.CHROME;
import static guru.qa.owner.data.Browser.FIREFOX;

public class ProjectConfig {

    static HomeWorkConfig config = ConfigFactory.create(HomeWorkConfig.class, System.getProperties());

    @BeforeAll
    static void configure() {

        Configuration.pageLoadStrategy = "eager";

        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = String.valueOf(config.getBrowserName());
        Configuration.browserVersion = config.getBrowserVersion();

        public WebDriver createDriver() {
            switch (config.getBrowserName()) {
                case CHROME: {
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
                }
                case FIREFOX: {
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                }
                default: {
                    throw new RuntimeException("No such driver");
                }
            }
        }

        switch (config.getEnv()) {
            case "local": {
                WebDriver.class ????
            }
            case "remote": {
                String remoteUrl = config.getRemoteWebDriverUrl();
                if (!Strings.isNullOrEmpty(remoteUrl)) {
                    Configuration.remote = remoteUrl;
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                            "enableVNC", true,
                            "enableVideo", true
                    ));
                    Configuration.browserCapabilities = capabilities;
                }
            }
            default: {
                throw new RuntimeException("No such driver");
            }
        }
    }
}

