package demoQAElements;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CheckBoxTest {
    @Test
    void selenideSearchTest(){
        open ("https://demoqa.com/");
        $(".card-up").click();

        $("#item-1").click();
        $(".rct-icon").click();
        $(byText("Word File.doc")).scrollIntoView(true);
        $(byText("Commands")).click();
        $(byText("Angular")).click();
        $(byText("Office")).click();
        $(byText("Word File.doc")).click();

        $("#result").shouldHave(text("You have selected :\n" +
                "commands\n" +
                "angular\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "wordFile"));

    }
}
