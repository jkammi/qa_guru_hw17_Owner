package guru.qa.owner;

import guru.qa.owner.config.WebDriverProvider__;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeWorkTest__ {

    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProvider__().get();
    }

    @Test
    public void testGitHub() {
        String title = driver.getTitle();
        assertEquals("GitHub: Let’s build from here · GitHub", title);
        driver.quit();
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }
}
