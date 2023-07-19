package pages.impl;

import components.impl.SearchComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.WebPage;

public class HomePage extends WebPage {
    private static final By SEARCH_COMPONENT_SELECTOR = By.cssSelector("#twotabsearchtextbox");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchComponent searchComponent(){
        return new SearchComponent(findElement(SEARCH_COMPONENT_SELECTOR));
    }

//    @FindBy(css = "#twotabsearchtextbox")
//    private WebElement searchInput;
//
//    public HomePage(WebDriver driver){
//        super(driver);
//    }
//
//    public void performSearch(String searchPhrase){
//        searchInput.sendKeys(searchPhrase);
//        searchInput.sendKeys(Keys.ENTER);
//    }
}