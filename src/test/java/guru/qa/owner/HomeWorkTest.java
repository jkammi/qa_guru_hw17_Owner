package guru.qa.owner;

import guru.qa.owner.config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeWorkTest extends TestBase{

    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());


    @Test
    public void testGithub() {
        open(config.getBaseUrl());
        String title = title();
        sleep(6000);
        assertEquals("GitHub: Let’s build from here · GitHub", title);
    }

}