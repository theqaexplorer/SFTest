import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SFHomePageLink {
    private final WebDriver driver;

    public SFHomePageLink(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSFHomePageLinkByText(String item_name) {
        return driver.findElement(By.linkText(item_name));
    }

    public WebElement getSFHomePageLinkByXPath(String item_xpath) {
        return driver.findElement(By.xpath(item_xpath));
    }
}
