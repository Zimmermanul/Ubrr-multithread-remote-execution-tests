package ru.ubrr.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {
    static String baseurl = "https://www.ubrr.ru/";

    @Step("Open mainPage")
    public void openMainPage() {
        open(baseurl);
        $("body").shouldHave(Condition.text("Уральский банк реконструкции и развития"));
    }

    @Step("Page title should have text 'Банк «УБРиР»'")
    public void checkPageTitle() {
        String expectedTitle = "Банк «УБРиР»";
        String actualTitle = title();
        assertThat(actualTitle).contains(expectedTitle);
    }

    @Step("Assert that date on page is actual")
    public void checkCurrencyDateOnPage(String date) {
        $(".currency__caption").shouldHave(text("Обновлено " + date));
    }

    @Step("Select and check that the city selection applies")
    public void selectAndCheckCity(String city) {
        $(".city-head__link").click();
        $(byText(city)).scrollIntoView(atBottom()).click();
        $("body").shouldHave(Condition.text(city));
    }
}
