import org.openqa.selenium.WebDriver;

public class SFHomePageTitle {
    private final WebDriver driver;

    public SFHomePageTitle(WebDriver driver) {
        this.driver = driver;
    }

    public String getSFHomePageTitle() {
        return driver.getTitle();
    }
}
