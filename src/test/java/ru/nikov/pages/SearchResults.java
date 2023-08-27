package ru.nikov.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class SearchResults {

    @Step("Переходим в первый товар в списке")
    public void chooseFirstItem() {
        $$( "article[data-autotest-id]").get( 0 ).click();
        switchTo().window( 1 );
    }

    @Step("Переходим во второй товар в списке")
    public void chooseSecondItem() {
        $$( "article[data-autotest-id]").get( 1 ).click();
        switchTo().window( 1 );
    }

}
