package guru.qa.owner.config;

import guru.qa.owner.data.Browser;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
})
public interface WebDriverConfig extends Config {

    @Key("browserName")
    @DefaultValue("CHROME")
    Browser getBrowserName();

    @Key("browserVersion")
    @DefaultValue("100.00")
    String getBrowserVersion();

    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();

    @DefaultValue("false")
    @Key("isRemote")
    Boolean isRemote();

    @Key("remoteWebDriverUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String getRemoteWebDriverUrl();
}