package ru.ubrr.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ubrr.helpers.DriverUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTests extends TestBase {
    SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
    Date date = new Date();

    @Test
    @Description("Сheck body and page title")
    @DisplayName("Successful open test")
    void openMainPageTest() {
        step("Open https://www.ubrr.ru/", () -> {
            open("https://www.ubrr.ru/");
            $("body").shouldHave(Condition.text("Уральский банк реконструкции и развития"));
        });

        step("Page title should have text 'Банк «УБРиР»'", () -> {
            String expectedTitle = "Банк «УБРиР»";
            String actualTitle = title();

            assertThat(actualTitle).contains(expectedTitle);
        });
    }

    @Test
    @Description("Currency displayed date should be actual")
    @DisplayName("Currency date test")
    void currencyDateTest() {

        step("Open url 'https://www.ubrr.ru/'", () -> {
            open("https://www.ubrr.ru/");
        });

        step("Get actual date", () -> {
            this.formatDate.setTimeZone(TimeZone.getTimeZone("Russia/Moscow"));
        });

        step("Assert that date on page is actual", () -> {
            $(".currency__caption").shouldHave(text("Обновлено " + formatDate.format(date)));
        });
    }


    @Test
    @Description("Page console log should not have errors")
    @DisplayName("Console log test")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.ubrr.ru/'", () ->
                open("https://www.ubrr.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @Description("Checks that the city selection applies")
    @DisplayName("City localisation test")
    void LocalisationTest() {

        step("Open url 'https://www.ubrr.ru/'", () -> {
            open("https://www.ubrr.ru/");
        });

        step("Choose city", () -> {
            $(".city-head__link").click();
            $(byText("Тюмень")).scrollIntoView(atBottom()).click();
        });

        step("Check text", () -> {
            $("body").shouldHave(Condition.text("Тюмень"));
            sleep(8000);
        });
    }

    @Test
    @Description("Navigation through tabs works and description matches")
    @DisplayName("Tabs navigation test")
    void TabsTest() {

        step("Open url 'https://www.ubrr.ru/'", () -> {
            open("https://www.ubrr.ru/");
        });
        step("Choose city", () -> {
            $(".city-head__link").click();
            $(byText("Тюмень")).scrollIntoView(atBottom()).click();
        });

        step("Navigate to credit cards", () -> {
            $(byXpath("//span[contains(.,'Кредитные карты')]")).click();
            $(byText("Все кредитные карты")).click();
        });

        step("Check text", () -> {
            $("body").shouldHave(Condition.text("Узнайте, какая кредитная карта подходит именно вам!"));
        });

        step("Navigate to credits", () -> {
            $(byXpath("//span[contains(.,'Кредиты')]")).click();
            $(byXpath("//span[contains(.,'Подобрать кредит')]")).click();
        });

        step("Check text", () -> {
            $("body").shouldHave(Condition.text("Кредит на любые цели"));
        });

        step("Navigate to deposits", () -> {
            $(byXpath("//span[contains(.,'Вклады')]")).click();
            $(byXpath("//span[contains(.,'Все вклады')]")).click();
        });

        step("Check text", () -> {
            $("body").shouldHave(Condition.text("Подобрать вклад"));
        });

        step("Navigate to deposit cards", () -> {
            $(byXpath("//span[contains(.,'Дебетовые карты')]")).click();
            $(byXpath("//a[contains(text(),'Дебетовые карты')]")).click();
        });

        step("Check text", () -> {
            $("body").shouldHave(Condition.text("Выберите свою"));
        });

        step("Navigate to hypothec", () -> {
            $(byXpath("//div[2]/div/ul/li[5]/a/span")).click();
            $(byXpath("//a[contains(.,'Подобрать программу ипотеки')]")).click();
        });

        step("Check text", () -> {
            $("body").shouldHave(Condition.text("Ипотечные программы"));
        });
    }
}