package guru.qa.owner.config;

import guru.qa.owner.data.Browser;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"
})

public interface WebDriverConfig extends Config {

    @Key("browserName")
    Browser getBrowserName();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("baseUrl")
    @DefaultValue("https://github.com/")
    String getBaseUrl();

    @Key("remoteWebDriverUrl")
    String getRemoteWebDriverUrl();
}