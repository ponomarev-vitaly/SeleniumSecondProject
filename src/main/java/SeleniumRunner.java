import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
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
//        chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com");
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        driver.quit();

        // Solution 1.

//        WebDriverManager.chromedriver().setup();
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.get("https://amazon.com");
//
//        String searchPhrase = "iphone";
//
//        WebElement searchInput = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
//        searchInput.sendKeys(searchPhrase);
//        searchInput.sendKeys(Keys.ENTER);
//
//        List<String> actualItems = driver.findElements(By.cssSelector(".s-search-results"))
//                .stream()
//                .map(element -> element.getText().toLowerCase())
//                .collect(Collectors.toList());
//        List<String> expectedItems = actualItems.stream()
//                .filter(item -> item.contains(searchPhrase))
//                .collect(Collectors.toList());
//
//        System.out.println(actualItems); // Print out actualItems and expectedItems into the console.
//        System.out.println("=============================>");
//        System.out.println(expectedItems);
//
//        Assert.assertEquals(expectedItems, actualItems);
//
//        driver.quit();

        // Solution 2.

        WebDriverManager.chromedriver().setup();

        ChromeOptions options1 = new ChromeOptions();
        options1.addArguments("--no-sandbox");
        options1.addArguments("--disable-dev-shm-usage");

        WebDriver driver1 = new ChromeDriver(options1);
        driver1.manage().window().maximize();
        driver1.get("https://amazon.com");

        String searchPhrase1 = "iphone";

        WebElement searchInput1 = driver1.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchInput1.sendKeys(searchPhrase1);
        searchInput1.sendKeys(Keys.ENTER);

        List<String> actualItems1 = driver1.findElements(By.cssSelector("[data-component-type='s-search-result'] h2.a-link-normal"))
                .stream()
                .map(element -> element.getText().toLowerCase() + element.getAttribute("href").toLowerCase())
                .collect(Collectors.toList());
        List<String> expectedItems1 = actualItems1.stream()
                .filter(item -> item.contains(searchPhrase1))
                .collect(Collectors.toList());

        System.out.println(actualItems1); // Print out actualItems1 and expectedItems1 into the console.
        System.out.println("=============================>");
        System.out.println(expectedItems1);

        Assert.assertEquals(expectedItems1, actualItems1);

        driver1.quit();
    }
}
