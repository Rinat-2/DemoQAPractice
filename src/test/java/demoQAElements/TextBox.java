package demoQAElements;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class TextBoxTest {
    @Test
    void selenideSearchTest(){
        open ("https://demoqa.com/");
        $(".card-up").click();

        $(".text").click();
        $("#userName").setValue("Rinat");
        $("#userEmail").setValue("tester123@gmail.com");
        $("#currentAddress").setValue("16 Albany Street\n" +
                "EDINBURGH");
        $("#permanentAddress").setValue("Loros Spiral Scratch\n" +
                "63 Queens Road\n" + "LEICESTER");
        $("#submit.btn").scrollIntoView(true);
        $("#submit.btn").click();

        $("#name").shouldHave(text("Rinat"));
        $("#email").shouldHave(text("tester123@gmail.com"));
        $("#currentAddress.mb-1").shouldHave(text("16 Albany Street EDINBURGH"));
        $("#permanentAddress.mb-1").shouldHave(text("Loros Spiral Scratch 63 Queens Road LEICESTER"));
    }
}
