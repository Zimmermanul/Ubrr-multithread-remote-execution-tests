package ru.ubrr.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
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

    @Step("Assert that date on currency converter is actual")
    public void checkCurrencyDate(String date) {
        $x("//div[contains(@class, 'converter_text')]").shouldHave(text("Актуально на 00:00, " + date));
    }

    @Step("Get currency price maps from page")
    public String getCurrencyExchange() {
        return $x("//div[contains(@class, 'currency_list')]").getText();
    }

    @Step("Get currency buy map from page")
    public Map<String, Double> getBuyMap(String input) {
        Map<String, Double> buyMap = new HashMap<>();
        String[] lines = input.split("\n");

        for (int i = 1; i < lines.length; i += 3) {
            String currency = lines[i];
            double buyPrice = Double.parseDouble(lines[i + 1]);
            buyMap.put(currency, buyPrice);
        }

        return buyMap;
    }

    @Step("Get currency sell map from page")
    public Map<String, Double> getSellMap(String input) {
        Map<String, Double> sellMap = new HashMap<>();
        String[] lines = input.split("\n");

        for (int i = 1; i < lines.length; i += 3) {
            String currency = lines[i];
            double sellPrice = Double.parseDouble(lines[i + 2]);
            sellMap.put(currency, sellPrice);
        }

        return sellMap;
    }

    @Step("Check currency calculation on page")
    public void calculatePriceByCurrencyValue(double convertionValue, Integer amountOfCurrency) {
        ElementsCollection currenciesContainers = $$x("//div[contains(@class, 'converter_input_inner')]");
        currenciesContainers.get(0).find(byXpath("//div[contains(@class, 'css-b62m3t-container')]")).shouldHave(Condition.text("RUB"));
        currenciesContainers.get(1).find(byXpath("//div[contains(@class, 'css-b62m3t-container')]")).shouldHave(Condition.text("USD"));
        $x("//input[contains(@id, 'input2')]").setValue(amountOfCurrency.toString());
        double rublesAmount = Double.parseDouble($x("//input[contains(@id, 'input1')]").getText());
        Assertions.assertThat(rublesAmount).isEqualTo(convertionValue * amountOfCurrency);
    }

    @Step("Select and check that the city selection applies")
    public void selectAndCheckCity(String city) {
        $(".city-head__link").click();
        $(byText(city)).scrollIntoView(atBottom()).click();
        $("body").shouldHave(Condition.text(city));
    }
}
