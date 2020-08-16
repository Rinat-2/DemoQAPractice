package demoQAElements;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("Rinat")
@Feature("RadioButtonTest")
public class RadioButtonTests {
    private static final String BASE_URL = "https://demoqa.com/";

    @BeforeEach
    public void initLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }

    @Test
    @DisplayName("CheckBoxTest")
    public void radioButtonTest (){
        step("Open website DemoQAPractice and click on Elements", () -> {
            open(BASE_URL);
            $(".card-up").click();
        });
        step("In the left menu select RadioButton and choose \"Yes\"" , () -> {
            $("#item-2").click();
            $(".custom-control-label").click();
        });
        step("We check that when you click, we get an answer with the word \"Yes\"" , () -> {
            $(".mt-3").shouldHave(text("You have selected Yes"));
        });
    }
}