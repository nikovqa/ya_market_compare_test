package ru.nikov.pages;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;
public class MainPage {


    @Step("Открываем главную страницу 'https://market.yandex.ru'")
    public MainPage openPage() {
        open( "https://market.yandex.ru" );
        return this;
    }

    @Step("Нажинаем на кнопку 'Каталог'")
    public MainPage clickCatalogueButton() {
        $( "#hamburger" ).click();

        return this;
    }

    @Step("Наводим курсор на «Зоотовары, в блоке «Для кошек» и нажимаем на «Лакомства»")
    public void hoverPetSuppliesAndClickTreatsForCats() {
        $x( "//span[text()='Зоотовары']").hover();
        $( "[href*='/catalog--lakomstva-dlia-koshek/62819/list?hid=15963668']" ).click();
    }
}
