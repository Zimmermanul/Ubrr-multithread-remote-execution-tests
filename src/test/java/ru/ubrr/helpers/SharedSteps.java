package ru.ubrr.helpers;

import io.qameta.allure.Step;
import ru.ubrr.utils.DriverUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.assertj.core.api.Assertions.assertThat;

public class SharedSteps {


    @Step("Get current date by Timezone")
    public String getCurrentDate(String timezone) {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
        formatDate.setTimeZone(TimeZone.getTimeZone(timezone));
        return formatDate.format(date);
    }

    @Step("Check that console logs not contain text 'SEVERE'")
    public void checkConsoleLogs() {
        assertThat(DriverUtils.getConsoleLogs()).doesNotContain("SEVERE");
    }
}
