package ru.nikov.tests;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.nikov.components.Filter;
import ru.nikov.pages.ComparePage;
import ru.nikov.pages.MainPage;
import ru.nikov.pages.ProductCard;
import ru.nikov.pages.SearchResults;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Owner("Nikolay Ovchinnikov")
    @Epic("UI")
    public class UITest extends TestBase {

    MainPage mainPage = new MainPage();
    Filter filter = new Filter();
    SearchResults searchResult = new SearchResults();

    ComparePage compare = new ComparePage();

    ProductCard firstItem = new ProductCard();

    ProductCard secondItem = new ProductCard();


    @DisplayName("Проверка сравнения двух товаров")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void compareItemsTest() {

        mainPage.openPage()
                .clickCatalogueButton()
                .hoverPetSuppliesAndClickTreatsForCats();

        filter.setPriceRange()
                .setDeliveryMethodCourier()
                .setFilterBrandWhiskas();

        searchResult.chooseFirstItem();

        firstItem.getFirstProductName()
                .addToCompareList()
                .close();

        filter.setFilterBrandTitBit();
        searchResult.chooseSecondItem();

        secondItem.getSecondProductName()
                .addToCompareList().goToCompareList();

        compare.verifyTotalPrice()
                .verifyAddedItems()
                .deleteFirstAddedItem()
                .verifyItemDeleted()
                .deleteCompareList()
                .verifyEmptyCompareList();
    }

}

