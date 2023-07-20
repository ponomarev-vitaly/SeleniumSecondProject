package components.impl;

import components.WebComponent;
import entities.SearchResultItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultItemComponent extends WebComponent {
    private static final By TITLE_SELECTOR = By.cssSelector("div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] span[class='a-size-medium a-color-base a-text-normal']");
//    private static final By DESCRIPTION_SELECTOR = By.cssSelector("div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] span[class='a-truncate-cut']");

    public SearchResultItemComponent(WebElement rootElement) {
        super(rootElement);
    }

    public SearchResultItem convertToSearchResultItem(){
        return new SearchResultItem(
                retrieveTitle(),
                retrieveHrefValue()
        );
    }

    private String retrieveTitle() {
        return findElement(TITLE_SELECTOR).getText().toLowerCase();
    }

    private String retrieveHrefValue() {
        return findElement(TITLE_SELECTOR).getAttribute("href").toLowerCase();
    }

//    public boolean containsSearchPhrase(String searchPhrase){
//        WebElement title = findElement(TITLE_SELECTOR);
//        return containsText(title.getText(), searchPhrase) || containsText(title.getAttribute("href"), searchPhrase);
////        return containsSearchPhraseIgnoringCase(searchPhrase, TITLE_SELECTOR)
////                || containsSearchPhraseIgnoringCase(searchPhrase, DESCRIPTION_SELECTOR);
//    }

//    private boolean containsText(String text, String searchPhrase){return text.toLowerCase().contains(searchPhrase);}

//    private boolean containsSearchPhraseIgnoringCase(String searchPhrase, By selector){
//        return findElement(selector).getText().toLowerCase().contains(searchPhrase);
//    }
}
