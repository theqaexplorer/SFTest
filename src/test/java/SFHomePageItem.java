import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SFHomePageItem {
    private final WebDriver driver;

    public SFHomePageItem(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSFHomePageItemByXPath(String item_xpath) {
        return driver.findElement(By.xpath(item_xpath));
    }

    public WebElement getSFHomePageItemBySelector(String item_selector) {
        return driver.findElement(By.cssSelector(item_selector));
    }
}
