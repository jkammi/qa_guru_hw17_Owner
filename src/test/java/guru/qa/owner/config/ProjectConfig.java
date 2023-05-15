package guru.qa.owner.config;

import com.codeborne.selenide.Configuration;
import com.google.common.base.Strings;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProjectConfig {
    public static void configure() {
        String env = System.getProperty("env");
        if (Strings.isNullOrEmpty(env)) {
            env = "local"; // Default to local if env property is not set
        }

        WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowserName().toString();
        Configuration.browserVersion = config.getBrowserVersion();

        if (env.equals("remote")) {
            Configuration.remote = config.getRemoteWebDriverUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}