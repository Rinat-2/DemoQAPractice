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
@Feature("TextBoxTest")
public class TextBoxTests {

    private static final String BASE_URL = "https://demoqa.com/";

    @BeforeEach
    public void initLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }
    @Test
    @DisplayName("CheckBoxTest")
    public void textBoxTest (){
        step("Open website DemoQAPractice and click on Elements", () -> {
            open(BASE_URL);
            $(".card-up").click();
        });
        step("In the TextBox, enter your name, email address, and current address and submit this", () -> {
            $(".text").click();
            $("#userName").setValue("Rinat");
            $("#userEmail").setValue("tester123@gmail.com");
            $("#currentAddress").setValue("16 Albany Street\n" +
                    "EDINBURGH");
            $("#permanentAddress").setValue("Loros Spiral Scratch\n" +
                    "63 Queens Road\n" + "LEICESTER");
            $("#submit.btn").scrollIntoView(true);
            $("#submit.btn").click();
        });
        step("We check whether all the data that was specified was written correctly", () -> {
            $("#name").shouldHave(text("Rinat"));
            $("#email").shouldHave(text("tester123@gmail.com"));
            $("#currentAddress.mb-1").shouldHave(text("16 Albany Street EDINBURGH"));
            $("#permanentAddress.mb-1").shouldHave(text("Loros Spiral Scratch 63 Queens Road LEICESTER"));
        });
    }
}