import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SFTest {
    private WebDriver driver;

    @BeforeEach
    public void installDriver() {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();

        driver.manage().window().setSize(new Dimension(1280, 768));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Test to verify that the home page opens successfully.
    @Test
    @Order(1)
    public void SFHomePageOpenTest() {
        openPage();
    }

    // Test to check the title of the home page.
    @Test
    @Order(2)
    public void SFHomePageTitleTest() {
        String title = "Онлайн-школа Skillfactory — онлайн-обучение востребованным IT-профессиям";

        openPage();

        SFHomePageTitle home_page_title = new SFHomePageTitle(driver);
        String title_for_test = home_page_title.getSFHomePageTitle();

        System.out.println(title_for_test);
        assertEquals(title_for_test, title);
    }

    // Test to validate the main navigation menu on the home page.
    @Test
    @Order(3)
    public void SFHomePageMainNaviTest() {
        String elements = "ОНЛАЙН-КУРСЫ\nБЕСПЛАТНО\nЦЕНТР КАРЬЕРЫ\nКОНТАКТЫ\nМЕДИА\nКОРПОРАТИВНОЕ ОБУЧЕНИЕ";
        String list_name = "main__nav";

        openPage();

        SFHomePageList main_navi = new SFHomePageList(driver);
        String elements_for_test = main_navi.getSFHomePageListByClass(list_name);

        System.out.println(elements_for_test);
        assertEquals(elements_for_test, elements);
    }

    // Test to verify that contact navigation item in the main menu redirects to the correct page.
    @Test
    @Order(4)
    public void SFHomePageMainNaviItemLinkTest() {
        String item_name = "КОНТАКТЫ";
        String title = "Контакты школы по работе с данными Skillfactory";

        openPage();

        SFHomePageLink main_navi_item_link = new SFHomePageLink(driver);
        WebElement item_for_test = main_navi_item_link.getSFHomePageLinkByText(item_name);
        item_for_test.click();

        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);

        String title_for_test = driver.getTitle();
        assertEquals(title_for_test, title);
    }

    // Test to validate that clicking a submenu item redirects to the correct page.
    @Test
    @Order(5)
    public void SFHomePageMainNaviSubmenuItemLinkTest() {
        String item_name = "Тестирование";
        String title = "Курсы тестировщиков, обучение QA-инженеров с нуля | ТОП-5 курсов";

        openPage();

        SFHomePageLink main_navi_submenu_item_link = new SFHomePageLink(driver);
        WebElement item_for_test = main_navi_submenu_item_link.getSFHomePageLinkByText(item_name);
        item_for_test.click();

        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);

        String title_for_test = driver.getTitle();

        System.out.println(title_for_test);
        assertEquals(title_for_test, title);
    }

    // Test to validate the elements in the "Directions" list.
    @Test
    @Order(6)
    public void SFHomePageDirectionsListTest() {
        String elements = "Программирование\n  Data Science\n  Аналитика данных\n  Тестирование\n  Высшее образование\n  Дизайн\n  Менеджмент\n  Все курсы";
        String list_name = "directions__list";

        openPage();

        SFHomePageList directions_list = new SFHomePageList(driver);
        String elements_for_test = directions_list.getSFHomePageListByClass(list_name);

        System.out.println(elements_for_test);
        assertEquals(elements_for_test, elements);
    }

    // Test to validate the "All courses" element from the "Directions" list.
    @Test
    @Order(7)
    public void SFHomePageDirectionsListLinkTest() {
        String item_name = "Все курсы";
        String title = "Онлайн-курсы: обучение IT-профессиям | 90+ курсов";

        openPage();

        SFHomePageLink directions_list_link = new SFHomePageLink(driver);
        WebElement item_for_test = directions_list_link.getSFHomePageLinkByText(item_name);
        item_for_test.click();

        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);

        String title_for_test = driver.getTitle();

        System.out.println(title_for_test);
        assertEquals(title_for_test, title);
    }

    // Test to verify that card item exists and has the correct h3 title
    @Test
    @Order(8)
    public void SFHomePageCoursesCardsItemNameTest() {
        String item_xpath = "//*[@id=\"START\"]/a/div[1]/h3";
        String name = "IT-специалист с нуля";

        openPage();

        SFHomePageItem courses_cards_item_name = new SFHomePageItem(driver);
        WebElement item_for_test = courses_cards_item_name.getSFHomePageItemByXPath(item_xpath);
        String name_for_test = item_for_test.getText();

        System.out.println(name_for_test);
        assertEquals(name_for_test, name);
    }

    // Test to verify that "See All Courses" button redirects to the correct page.
    @Test
    @Order(9)
    public void SFHomePageAllCoursesLinkTest() {
        String item_xpath = "//*[@id=\"rec713617003\"]/div/div/div/section/div/a";
        String title = "Онлайн-курсы: обучение IT-профессиям | 90+ курсов";

        openPage();

        SFHomePageLink all_course_link = new SFHomePageLink(driver);
        WebElement item_for_test = all_course_link.getSFHomePageLinkByXPath(item_xpath);
        item_for_test.click();

        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);

        String title_for_test = driver.getTitle();

        System.out.println(title_for_test);
        assertEquals(title_for_test, title);
    }

    // Test to verify that H2 header is correct.
    @Test
    @Order(10)
    public void SFHomePageH2HeaderTest() {
        String item_xpath = "/html/body/div[4]/div/div/div/section/div/h2";
        String name = "Помогаем получить высшее образование в IT — онлайн";

        openPage();

        SFHomePageItem higher_education_header = new SFHomePageItem(driver);
        WebElement item_for_test = higher_education_header.getSFHomePageItemByXPath(item_xpath);
        String name_for_test = item_for_test.getText();

        System.out.println(name_for_test);
        assertEquals(name_for_test, name);
    }

    // Test to verify that choose program button redirects to the correct page.
    @Test
    @Order(11)
    public void SFHomePageChooseProgramButtonLinkTest() {
        String item_name = "Выбрать программу";
        String title = "Курсы высшего образования онлайн от Skillfactory и ВУЗов России";

        openPage();

        SFHomePageLink higher_education_button = new SFHomePageLink(driver);
        WebElement item_for_test = higher_education_button.getSFHomePageLinkByText(item_name);
        item_for_test.click();

        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);

        String title_for_test = driver.getTitle();

        System.out.println(title_for_test);
        assertEquals(title_for_test, title);
    }

    // Test to verify that participate button redirects to the correct page.
    @Test
    @Order(12)
    public void SFHomePageParticipateButtonLinkTest() {
        String item_name = "Участвовать";
        String title = "Выберите свою IT-профессию за 1 день со Skillfactory";

        openPage();

        SFHomePageLink rentgen_button = new SFHomePageLink(driver);
        WebElement item_for_test = rentgen_button.getSFHomePageLinkByText(item_name);
        item_for_test.click();

        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);

        String title_for_test = driver.getTitle();

        System.out.println(title_for_test);
        assertEquals(title_for_test, title);
    }

    // Test to validate the name field placeholder.
    @Test
    @Order(13)
    public void SFHomePageNameFieldPlaceholderTest() {
        String item_selector = "#form625408054>div.t-form__inputsbox>div.t-input-group.t-input-group_nm>div>input";
        String placeholder = "Имя";

        openPage();

        SFHomePageItem name_field_placeholder = new SFHomePageItem(driver);
        WebElement item_for_test = name_field_placeholder.getSFHomePageItemBySelector(item_selector);
        String placeholder_for_test = item_for_test.getAttribute("placeholder");

        System.out.println(placeholder_for_test);
        assertEquals(placeholder_for_test, placeholder);
    }

    // Test to validate the email field placeholder.
    @Test
    @Order(14)
    public void SFHomePageEmailFieldPlaceholderTest() {
        String item_selector = "#form625408054>div.t-form__inputsbox>div.t-input-group.t-input-group_em>div>input";
        String placeholder = "Почта";

        openPage();

        SFHomePageItem name_field_placeholder = new SFHomePageItem(driver);
        WebElement item_for_test = name_field_placeholder.getSFHomePageItemBySelector(item_selector);
        String placeholder_for_test = item_for_test.getAttribute("placeholder");

        System.out.println(placeholder_for_test);
        assertEquals(placeholder_for_test, placeholder);
    }

    // Test to validate the phone field placeholder.
    @Test
    @Order(15)
    public void SFHomePagePhoneFieldPlaceholderTest() {
        String item_selector = "#input_1676828667932";
        String placeholder = "(999) 999-99-99";

        openPage();

        SFHomePageItem name_field_placeholder = new SFHomePageItem(driver);
        WebElement item_for_test = name_field_placeholder.getSFHomePageItemBySelector(item_selector);
        String placeholder_for_test = item_for_test.getAttribute("placeholder");

        System.out.println(placeholder_for_test);
        assertEquals(placeholder_for_test, placeholder);
    }

    // Positive test for contact form name field
    @ParameterizedTest
    @Order(16)
    @ValueSource(strings = {"Ivan", "Иван", "I", "И", "Иван Иванов"})
    public void SFHomePageNameFieldPositiveInputTest(String argument) {
        String item_selector = "#form625408054>div.t-form__inputsbox>div.t-input-group.t-input-group_nm>div>input";
        String item_selector_with_error = "/html/body/div[16]/div/div/div[7]/div[1]/form/div[2]/div[1]/div/div";
        String button_selector = "#form625408054>div.t-form__inputsbox>div.tn-form__submit>button";

        openPage();

        SFHomePageItem name_field_input = new SFHomePageItem(driver);
        WebElement item_for_test = name_field_input.getSFHomePageItemBySelector(item_selector);
        item_for_test.clear();
        item_for_test.sendKeys(argument);

        WebElement button_for_test = name_field_input.getSFHomePageItemBySelector(button_selector);
        button_for_test.click();

        WebElement item_with_error = name_field_input.getSFHomePageItemByXPath(item_selector_with_error);
        String message = item_with_error.getText();

        System.out.println(message);
        assertTrue(message.isBlank());
    }

    // Negative test for contact form name field
    @ParameterizedTest
    @Order(17)
    @ValueSource(strings = {"1van", "Iv@n", "1", "@", "", " "})
    public void SFHomePageNameFieldNegativeInputTest(String argument) {
        String item_selector = "#form625408054>div.t-form__inputsbox>div.t-input-group.t-input-group_nm>div>input";
        String item_selector_with_error = "/html/body/div[16]/div/div/div[7]/div[1]/form/div[2]/div[1]/div/div";
        String button_selector = "#form625408054>div.t-form__inputsbox>div.tn-form__submit>button";

        openPage();

        SFHomePageItem name_field_input = new SFHomePageItem(driver);
        WebElement item_for_test = name_field_input.getSFHomePageItemBySelector(item_selector);
        item_for_test.clear();
        item_for_test.sendKeys(argument);

        WebElement button_for_test = name_field_input.getSFHomePageItemBySelector(button_selector);
        button_for_test.click();

        WebElement item_with_error = name_field_input.getSFHomePageItemByXPath(item_selector_with_error);
        String message = item_with_error.getText();

        System.out.println(message);
        assertFalse(message.isBlank());
    }

    // Positive test for contact form email field
    @ParameterizedTest
    @Order(18)
    @ValueSource(strings = {"test@example.com", "TEST@Example.com", "test1@example.com", "1test@example.com", "test@email1.ru", "te-st@example.com", "test@e-mail.ru", "t_est@example.com", "t.est@example.com"})
    public void SFHomePageEmailFieldPositiveInputTest(String argument) {
        String item_selector = "#form625408054>div.t-form__inputsbox>div.t-input-group.t-input-group_em>div>input";
        String item_selector_with_error = "/html/body/div[16]/div/div/div[7]/div[1]/form/div[2]/div[2]/div/div";
        String button_selector = "#form625408054>div.t-form__inputsbox>div.tn-form__submit>button";

        openPage();

        SFHomePageItem name_field_input = new SFHomePageItem(driver);
        WebElement item_for_test = name_field_input.getSFHomePageItemBySelector(item_selector);
        item_for_test.clear();
        item_for_test.sendKeys(argument);

        WebElement button_for_test = name_field_input.getSFHomePageItemBySelector(button_selector);
        button_for_test.click();

        WebElement item_with_error = name_field_input.getSFHomePageItemByXPath(item_selector_with_error);
        String message = item_with_error.getText();

        System.out.println(message);
        assertTrue(message.isBlank());
    }

    // Negative test for contact form email field
    @ParameterizedTest
    @Order(19)
    @ValueSource(strings = {"", "test@emailru", "testexample.com", "testexamplecom", "t est@example.com", "test@e xample.com", "test@e_xample.com"})
    public void SFHomePageEmailFieldNegativeInputTest(String argument) {
        String item_selector = "#form625408054>div.t-form__inputsbox>div.t-input-group.t-input-group_em>div>input";
        String item_selector_with_error = "/html/body/div[16]/div/div/div[7]/div[1]/form/div[2]/div[2]/div/div";
        String button_selector = "#form625408054>div.t-form__inputsbox>div.tn-form__submit>button";

        openPage();

        SFHomePageItem name_field_input = new SFHomePageItem(driver);
        WebElement item_for_test = name_field_input.getSFHomePageItemBySelector(item_selector);
        item_for_test.clear();
        item_for_test.sendKeys(argument);

        WebElement button_for_test = name_field_input.getSFHomePageItemBySelector(button_selector);
        button_for_test.click();

        WebElement item_with_error = name_field_input.getSFHomePageItemByXPath(item_selector_with_error);
        String message = item_with_error.getText();

        System.out.println(message);
        assertFalse(message.isBlank());
    }

    // Positive test for contact form phone number field
    @ParameterizedTest
    @Order(20)
    @ValueSource(strings = {"9111111111", "8111111111", "495-111-11-11", "495 111-11-11", "495 111-11-11"})
    public void SFHomePagePhoneFieldPositiveInputTest(String argument) {
        String item_selector = "#input_1676828667932";
        String item_selector_with_error = "/html/body/div[16]/div/div/div[7]/div[1]/form/div[2]/div[3]/div/div[2]";
        String button_selector = "#form625408054>div.t-form__inputsbox>div.tn-form__submit>button";

        openPage();

        SFHomePageItem name_field_input = new SFHomePageItem(driver);
        WebElement item_for_test = name_field_input.getSFHomePageItemBySelector(item_selector);
        item_for_test.clear();
        item_for_test.sendKeys(argument);

        WebElement button_for_test = name_field_input.getSFHomePageItemBySelector(button_selector);
        button_for_test.click();

        WebElement item_with_error = name_field_input.getSFHomePageItemByXPath(item_selector_with_error);
        String message = item_with_error.getText();

        System.out.println(message);
        assertTrue(message.isBlank());
    }

    // Negative test for contact form phone number field
    @ParameterizedTest
    @Order(21)
    @ValueSource(strings = {"", " ", "!", "a", "1111111111", "1"})
    public void SFHomePagePhoneFieldNegativeInputTest(String argument) {
        String item_selector = "#input_1676828667932";
        String item_selector_with_error = "/html/body/div[16]/div/div/div[7]/div[1]/form/div[2]/div[3]/div/div[2]";
        String button_selector = "#form625408054>div.t-form__inputsbox>div.tn-form__submit>button";

        openPage();

        SFHomePageItem name_field_input = new SFHomePageItem(driver);
        WebElement item_for_test = name_field_input.getSFHomePageItemBySelector(item_selector);
        item_for_test.clear();
        item_for_test.sendKeys(argument);

        WebElement button_for_test = name_field_input.getSFHomePageItemBySelector(button_selector);
        button_for_test.click();

        WebElement item_with_error = name_field_input.getSFHomePageItemByXPath(item_selector_with_error);
        String message = item_with_error.getText();

        System.out.println(message);
        assertFalse(message.isBlank());
    }

    @AfterEach
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();  // Завершаем сессию и закрываем все окна браузера
        }
    }

    private void openPage() {
        SFMainPage sfMainPage = new SFMainPage(driver);
        sfMainPage.sfOpenPage();
    }

}
