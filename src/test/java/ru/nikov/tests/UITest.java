package ru.nikov.tests;
import dev.failsafe.internal.util.Assert;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.nikov.components.Filter;
import ru.nikov.pages.ComparePage;
import ru.nikov.pages.MainPage;
import ru.nikov.pages.ProductCard;
import ru.nikov.pages.SearchResults;

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

        firstItem.getFirstAddedProductName()
                .addToCompareList()
                .close();

        filter.setFilterBrandTitBit();
        searchResult.chooseSecondItem();

        secondItem.getSecondAddedProductName()
                .addToCompareList().goToCompareList();

//        System.out.println(firstItem.getFirstItemName() + " | " + compare.getFirstItemNameFromCompareList());
//        System.out.println(secondItem.getSecondItemName() + " | " + compare.getSecondItemNameFromCompareList());

        step("Проверяем что добавленные товары, совпадают с товарами из списка сравнения", () ->{

            assertTrue( firstItem.getFirstItemName().equalsIgnoreCase( compare.getFirstItemNameFromCompareList()));
            assertTrue( secondItem.getSecondItemName().equalsIgnoreCase( compare.getSecondItemNameFromCompareList()));

        });

        compare.verifyTotalPrice()
                .deleteFirstAddedItem()
                .verifyItemDeleted()
                .deleteCompareList()
                .verifyEmptyCompareList();
    }

}

