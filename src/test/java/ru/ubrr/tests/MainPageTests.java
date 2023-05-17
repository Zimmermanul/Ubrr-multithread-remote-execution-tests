package ru.ubrr.tests;

import io.qameta.allure.*;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ubrr.annotations.Layer;
import ru.ubrr.annotations.QAAutomation;
import ru.ubrr.base.TestBase;
import ru.ubrr.helpers.SharedSteps;
import ru.ubrr.pages.MainPage;

import static ru.ubrr.testData.StaticData.ZIMMERMANUL;


@Feature("Main Page")
@Story("Main flow")
@Layer("Ui")

public class MainPageTests extends TestBase {


    @Test
    @AllureId("5759")
    @DisplayName("Successful open test")
    @QAAutomation(ZIMMERMANUL)
    void openMainPageTest() {
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();
        mainPage.checkPageTitle();
    }

    @Test
    @AllureId("5761")
    @DisplayName("Currency date test")
    @QAAutomation(ZIMMERMANUL)
    void currencyDateTest() {
        MainPage mainPage = new MainPage();
        SharedSteps sharedSteps = new SharedSteps();
        mainPage.openMainPage();
        mainPage.checkCurrencyDateOnPage(sharedSteps.getCurrentDate("Russia/Moscow"));
    }


    @Test
    @AllureId("5762")
    @DisplayName("Console log test")
    @QAAutomation(ZIMMERMANUL)
    void consoleShouldNotHaveErrorsTest() {
        MainPage mainPage = new MainPage();
        SharedSteps sharedSteps = new SharedSteps();
        mainPage.openMainPage();
        sharedSteps.checkConsoleLogs();

    }

    @Test
    @AllureId("5764")
    @DisplayName("City localisation test")
    @QAAutomation(ZIMMERMANUL)
    void LocalisationTest() {
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();
        mainPage.selectAndCheckCity("Тюмень");
    }
}