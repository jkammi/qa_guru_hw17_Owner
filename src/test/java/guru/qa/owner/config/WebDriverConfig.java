package guru.qa.owner.config;

import guru.qa.owner.data.Browser;
import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:${env}.properties"
})

public interface HomeWorkConfig extends Config {

    @Key("browserName")
    @DefaultValue("CHROME")
    Browser getBrowserName();

    @Key("browserVersion")
    @DefaultValue("100.00")
    String getBrowserVersion();

    @Key("env")
    @DefaultValue("local")
    String getEnv();

    @Key("remoteWebDriverUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String getRemoteWebDriverUrl();

    @Key("baseUrl")
    @DefaultValue("https://wildberries.ru")
    String getBaseUrl();

}
