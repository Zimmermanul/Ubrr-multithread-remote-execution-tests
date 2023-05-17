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

import java.util.Map;

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
        SharedSteps sharedSteps = new SharedSteps();
        mainPage.openMainPage();
        mainPage.checkPageTitle();
        sharedSteps.checkConsoleLogs();
    }

    @Test
    @AllureId("5761")
    @DisplayName("Currency test")
    @QAAutomation(ZIMMERMANUL)
    void currencyDateTest() {
        MainPage mainPage = new MainPage();
        SharedSteps sharedSteps = new SharedSteps();
        mainPage.openMainPage();
        mainPage.checkCurrencyDate(sharedSteps.getCurrentDate("Russia/Moscow"));
        String currencyPriceFromPage = mainPage.getCurrencyExchange();
        Map<String, Double> buyMap = mainPage.getBuyMap(currencyPriceFromPage);
        mainPage.calculatePriceByCurrencyValue(buyMap.get("USD"), 100);
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