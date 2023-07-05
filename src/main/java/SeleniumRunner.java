import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.stream.Collectors;

public class SeleniumRunner {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://amazon.com");

        String searchPhrase = "iphone";

        WebElement searchInput = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchInput.sendKeys(searchPhrase);
        searchInput.sendKeys(Keys.ENTER);

        List<String> actualItems = driver.findElements(By.cssSelector("[data-component-type='s-search-result'] h2.a-link-normal"))
                .stream()
                .map(element -> element.getText().toLowerCase() + element.getAttribute("href").toLowerCase())
                .collect(Collectors.toList());
        List<String> expectedItems = actualItems.stream()
                .filter(item -> item.contains(searchPhrase))
                .collect(Collectors.toList());

        System.out.println(actualItems); // Print out actualItems and expectedItems into the console.
        System.out.println("=============================>");
        System.out.println(expectedItems);

        Assertions.assertEquals(expectedItems, actualItems);

        driver.quit();
    }
}
