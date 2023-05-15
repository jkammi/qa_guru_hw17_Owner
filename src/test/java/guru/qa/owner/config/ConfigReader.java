package guru.qa.owner.config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    Instance;

    public static final WebDriverConfig
            webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public WebDriverConfig read() {
        return webDriverConfig;
    }
}