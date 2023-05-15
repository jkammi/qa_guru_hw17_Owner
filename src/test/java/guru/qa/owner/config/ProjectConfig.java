package guru.qa.owner.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class ProjectConfig {
    private final WebDriverConfig webDriverConfig;

    public ProjectConfig(WebDriverConfig webDriverConfig) {
        this.webDriverConfig = webDriverConfig;
    }

    public void webDriverConfig() {
        Configuration.baseUrl = webDriverConfig.getBaseUrl();
        Configuration.browser = webDriverConfig.getBrowserName().toString();
        Configuration.browserVersion = webDriverConfig.getBrowserVersion();

        if (webDriverConfig.isRemote()) {
            Configuration.remote = webDriverConfig.getRemoteWebDriverUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}