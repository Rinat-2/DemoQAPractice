package tests.demoQAElements;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


@Owner("Rinat")
@Feature("CheckBoxTest")
@Tag("CheckBoxTest")
public class CheckBoxTests {

    private static final String BASE_URL = "https://demoqa.com/";

    @BeforeEach
    public void initLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }

    @Test
    @DisplayName("CheckBoxTest")
    public void checkBoxTest(){
        step("Open website DemoQAPractice and click on Elements", () -> {
            open(BASE_URL);
            $(".card-up").click();
        });
        step("In the checkbox box, select the elements that you want to click on", () -> {
            $("#item-1").click();
            $(".rct-icon").click();
            $(byText("Word File.doc")).scrollIntoView(true);
            $(byText("Commands")).click();
            $(byText("Angular")).click();
            $(byText("Office")).click();
            $(byText("Word File.doc")).click();
        });
        step("We check that all the elements that were clicked are displayed as selected", () -> {
            $("#result").shouldHave(text("You have selected :\n" +
                    "commands\n" +
                    "angular\n" +
                    "office\n" +
                    "public\n" +
                    "private\n" +
                    "classified\n" +
                    "general\n" +
                    "wordFile"));
        });
    }
}