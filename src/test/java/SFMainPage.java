import org.openqa.selenium.WebDriver;

public class SFMainPage {
    private final WebDriver driver;
    String url = "https://www.skillfactory.ru";

    public SFMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sfOpenPage() {
        driver.get(url);
    }
}
