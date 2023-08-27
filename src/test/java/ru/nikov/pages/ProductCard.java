package ru.nikov.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;


public class ProductCard {

    private String firstItemName,
            secondItemName;
    public String getFirstItemName() {
        return firstItemName;
    }
    public String getSecondItemName() {
        return secondItemName;
    }

    @Step("Добавляем товар в список сравнения")
    public ProductCard addToCompareList() {
        $( "div[data-auto='compare-button'" ).shouldBe( Condition.visible ).click();
        $x( "//span[text()='В сравнении']" ).shouldBe( Condition.visible );

        return this;
    }

    @Step("Закрываем карточку с товаром")
    public ProductCard close() {
        closeWindow();
        switchTo().window( 0 );

        return this;
    }



    @Step("Открываем список сравнения")
    public ProductCard goToCompareList() {
        $( "a[href*='/my/compare-lists']" ).shouldBe( Condition.visible ).click();

        return this;
    }

    @Step("Получаем имя первого  товара")
    public ProductCard getFirstProductName() {
        String s = $( "meta[itemprop='name']" ).getAttribute( "content" );
        firstItemName = s;

        return this;
    }
    @Step("Получаем имя второго  товара")
    public ProductCard getSecondProductName() {
        String s = $( "meta[itemprop='name']" ).getAttribute( "content" );
        secondItemName = s;

        return this;
    }
}