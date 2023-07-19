import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.impl.HomePage;
import pages.impl.SearchResultsPage;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonSearchTest {
    private static final String searchPhrase = "iphone";
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUpDriver(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @BeforeAll
    public static void setUpWait(){
        wait = new WebDriverWait(driver, 15);
    }

    private static void switchOffImplicitWait(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
    @Test
    public void AmazonSearch(){
        driver.get("https://amazon.com");

        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

        homePage.searchComponent().performSearch(searchPhrase);

        List<String> actualItems = searchResultsPage.searchResultsItemsText();
        List<String> expectedItems = searchResultsPage.searchResultsItemsWithText(searchPhrase);

        Assertions.assertEquals(expectedItems, actualItems);

//        WebElement searchInput = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
//        searchInput.sendKeys(searchPhrase);
//        searchInput.sendKeys(Keys.ENTER);
//
//        List<String> actualItems = driver.findElements(By.cssSelector("[data-component-type='s-search-result'] h2.a-link-normal"))
//                .stream()
//                .map(element -> element.getText().toLowerCase() + element.getAttribute("href").toLowerCase())
//                .collect(Collectors.toList());
//        List<String> expectedItems = actualItems.stream()
//                .filter(item -> item.contains(searchPhrase))
//                .collect(Collectors.toList());

//        System.out.println(actualItems); // Print out actualItems and expectedItems into the console.
//        System.out.println("=============================>");
//        System.out.println(expectedItems);

//        Assertions.assertEquals(expectedItems, actualItems);
    }
    @AfterAll
    public static void tearDownDriver(){
//        System.out.println(LocalDateTime.now());
        driver.quit();
    }
}
