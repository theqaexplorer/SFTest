import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SFHomePageList {
    private final WebDriver driver;

    public SFHomePageList(WebDriver driver) {
        this.driver = driver;
    }

    public String getSFHomePageListByClass(String list_name) {
        return driver.findElements(By.className(list_name)).getFirst().getText();
    }
}
