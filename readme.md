# Final Task: Test Automation Suite for Skillfactory website

## Overview
This project is an automated testing suite for the SkillFactory website ([https://skillfactory.ru/](https://skillfactory.ru/)), implemented using **Java**, **JUnit 5**, and **Selenium WebDriver**. The suite is designed to verify the functionality and structure of the website using a variety of test scenarios.

---

## Test Scenarios
The suite includes the following test cases:

1. **SFHomePageOpenTest**: Verifies that the home page loads successfully.
2. **SFHomePageTitleTest**: Checks the title of the home page.
3. **SFHomePageMainNaviTest**: Validates the items in the main navigation menu.
4. **SFHomePageMainNaviItemLinkTest**: Verifies the "Контакты" link redirects to the correct page.
5. **SFHomePageMainNaviSubmenuItemLinkTest**: Tests redirection for submenu items like "Тестирование".
6. **SFHomePageDirectionsListTest**: Validates the list of course directions.
7. **SFHomePageDirectionsListLinkTest**: Tests navigation via the "Все курсы" link in the directions list.
8. **SFHomePageCoursesCardsItemNameTest**: Verifies card item titles on the main page.
9. **SFHomePageAllCoursesLinkTest**: Ensures the "See All Courses" button navigates to the correct page.
10. **SFHomePageH2HeaderTest**: Validates the H2 header text.
11. **SFHomePageChooseProgramButtonLinkTest**: Checks the "Выбрать программу" button functionality.
12. **SFHomePageParticipateButtonLinkTest**: Tests redirection via the "Участвовать" button.
13. **SFHomePageNameFieldPlaceholderTest**: Verifies placeholder text for the "Name" field.
14. **SFHomePageEmailFieldPlaceholderTest**: Verifies placeholder text for the "Email" field.
15. **SFHomePagePhoneFieldPlaceholderTest**: Verifies placeholder text for the "Phone" field.
16. **SFHomePageNameFieldPositiveInputTest**: Validates positive inputs for the "Name" field.
17. **SFHomePageNameFieldNegativeInputTest**: Validates
negative inputs for the "Name" field.
18. **SFHomePageEmailFieldPositiveInputTest**: Validates
positive inputs for the "Email" field.
19. **SFHomePageEmailFieldNegativeInputTest**: Validates
negative inputs for the "Email" field.
20. **SFHomePagePhoneFieldPositiveInputTest**: Validates
positive inputs for the "Phone" field
21. **SFHomePagePhoneFieldNegativeInputTest**: Validates
negative inputs for the "Phone" field.

## How to Run the Project

### Prerequisites
1. **Java Development Kit (JDK):** Ensure JDK is installed and configured.
2. **Apache Maven:** Required for dependency management and test execution.
3. **Google Chrome:** Install the latest version of Google Chrome.
4. **ChromeDriver:** Ensure the ChromeDriver version matches your browser version.

### Running the Project with Maven
1. Open a terminal and navigate to the project folder containing `pom.xml`.
2. Use the following commands:
   - **Clean the project and install:** `mvn clean install`
   - **Run all tests:** `mvn test`

### Running the Project in IntelliJ IDEA
1. **Import the Project:**
   - Open IntelliJ IDEA.
   - Select **File > Open**, and navigate to the project folder.
   - Choose the `pom.xml` file to load the project as a Maven project.

## Project Files
### Main file for running tests
1. **SFTest.java**
   - The entry point for executing all automated test cases against the SkillFactory website.
   - Integrates test cases to validate functionality and structure using the Page Object Model classes.

### Page Object Model Classes
1. **SFMainPage.java**
   - Responsible for opening the SkillFactory homepage.
   - URL: `https://www.skillfactory.ru`.
   - Methods:
     - `sfOpenPage()`: Opens the homepage in the browser.

2. **SFHomePageTitle.java**
   - Retrieves the title of the SkillFactory homepage.
   - Methods:
     - `getSFHomePageTitle()`: Returns the title of the homepage.

3. **SFHomePageList.java**
   - Retrieves the first text element from a list by its class name.
   - Methods:
     - `getSFHomePageListByClass(String list_name)`: Returns the text of the first element in the list.

4. **SFHomePageLink.java**
   - Provides methods to locate links by their text or XPath.
   - Methods:
     - `getSFHomePageLinkByText(String item_name)`: Returns a link element by its text.
     - `getSFHomePageLinkByXPath(String item_xpath)`: Returns a link element by its XPath.

5. **SFHomePageItem.java**
   - Retrieves specific items on the homepage using XPath or CSS selectors.
   - Methods:
     - `getSFHomePageItemByXPath(String item_xpath)`: Returns an item by its XPath.
     - `getSFHomePageItemBySelector(String item_selector)`: Returns an item by its CSS selector.




