package ru.nikov.components;

import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Filter {

    @Step("Установливаем фильтр по цене: от 50 руб до 150 руб")
    public Filter setPriceRange() {

        $( "._3qxDp", 0 ).click();
        $( "._3qxDp", 0 ).sendKeys( "50" );
        $( "._3qxDp", 1 ).click();
        $( "._3qxDp", 1 ).sendKeys( "150" );

        return this;
    }


    @Step("Выбираем способ доставки: «С учетом доставки курьером»")
    public Filter setDeliveryMethodCourier() {

        $x( "//span[text()='Курьером']" ).click();
        $( "#hamburger" ).scrollIntoView( false );

//        $("div[data-auto='preloader']").shouldNotBe(appear);
//        $("span[data-auto='spinner']").shouldNotBe(appear);

        sleep( 2000 ); //todo dodelat' proverku na spiner

        return this;
    }

    @Step("Ищем производителя и устанавливаем по нему фильтр : «Whiskas»")
    public Filter setFilterBrandWhiskas() {

        $x( "//span[text()='Показать всё']" ).click();
        $( "._31fu1", 2 ).shouldHave( text( "Найти производителя" ) );
        $( "._3qxDp", 2 ).click();
        $( "._3qxDp", 2 ).sendKeys( "w" );
        $x( "//span[text()='Whiskas']" ).click();
        $( "div[data-auto='preloader']" ).shouldNotBe( appear );
        sleep( 2000 );

        return this;
    }

    @Step  ("Меняем производителя в фильтре на Titbit")
    public Filter setFilterBrandTitBit() {

            $x( "//span[text()='Whiskas']" ).click();
            $( "._3qxDp", 2 ).doubleClick();
            $( "._3qxDp", 2 ).sendKeys( "t" );
            $x( "//span[text()='Titbit']" ).click();
            $( "div[data-auto='preloader']" ).shouldNotBe( appear );
            sleep( 2000 );

        return this;
        }



}