package components.impl;

import components.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultItemComponent extends WebComponent {
    private static final By TITLE_SELECTOR = By.cssSelector("div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] span[class='a-size-medium a-color-base a-text-normal']");
    private static final By DESCRIPTION_SELECTOR = By.cssSelector("div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] span[class='a-truncate-cut']");

    public SearchResultItemComponent(WebElement rootElement) {
        super(rootElement);
    }

    public boolean containsSearchPhrase(String searchPhrase){
        return containsSearchPhraseIgnoringCase(searchPhrase, TITLE_SELECTOR)
                || containsSearchPhraseIgnoringCase(searchPhrase, DESCRIPTION_SELECTOR);
    }

    private boolean containsSearchPhraseIgnoringCase(String searchPhrase, By selector){
        return findElement(selector).getText().toLowerCase().contains(searchPhrase);
    }
}
