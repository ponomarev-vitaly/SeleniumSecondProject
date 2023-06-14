import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

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
        driver.get("https://github.com");

        WebElement searchInput = driver.findElement(By.cssSelector("[name='q']"));
        searchInput.sendKeys("Selenium");
        searchInput.sendKeys(Keys.ENTER);

        driver.quit();
    }
}
