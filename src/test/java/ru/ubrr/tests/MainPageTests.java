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
}