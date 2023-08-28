package ru.nikov.pages;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComparePage {
    ElementsCollection productPrice = $$( "span[data-autotest-value]" );
    ElementsCollection products = $$( ".zvRJM" );

    @Step("Проверяем, что сумма стоимостей товаров не превышает 300 руб")
    public ComparePage verifyTotalPrice() {
        assertTrue( parseInt( (productPrice.get( 0 )).getAttribute( "data-autotest-value" ) )
                + parseInt( (productPrice.get( 1 )).getAttribute( "data-autotest-value" ) ) < 300 );

        return this;
    }
    @Step("Получаем имя первого продукта")
    public String getFirstItemNameFromCompareList() {
        String s = (products.get( 1 ).text());

        return s;
    }
    @Step("Получаем имя второго продукта")
    public String getSecondItemNameFromCompareList() {
        String s = (products.get( 0 ).text());

        return s;
    }


    @Step("Удаляем продукт «Whiskas» из сравнения")
    public ComparePage deleteFirstAddedItem() {
        products.get( 1 ).hover();
        $( "div[aria-label='Удалить']", 1).click();

        return this;
    }

    @Step("Очищаем список сравнения нажав на «Удалить список»")
    public ComparePage deleteCompareList() {
        $( byText( "Удалить список" ) ).shouldBe( visible ).click();

        return this;
    }

    @Step("Проверяем что товар производителя «Whiskas» не отображается")
    public ComparePage verifyItemDeleted() {

        $$( ".zvRJM" ).shouldHave(CollectionCondition.size( 1 )).shouldHave(CollectionCondition.texts( getSecondItemNameFromCompareList() ));

        return this;
    }

    @Step("Проверяем что список сравнения пуст")
    public ComparePage verifyEmptyCompareList() {

        $( ".kpCeE" ).shouldHave( text( "Сравнивать пока нечего" ) );

        return this;
    }











}
