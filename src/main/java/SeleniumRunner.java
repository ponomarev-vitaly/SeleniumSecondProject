import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumRunner {
    public static void main(String[] args) {
//        chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com");
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        driver.quit();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://amazon.com");

        WebElement searchInput = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchInput.sendKeys("Iphone");
        searchInput.sendKeys(Keys.ENTER);

        driver.quit();
    }
}
