package test_demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest() {

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=firstName]").setValue("Test");
        $("[id=lastName]").setValue("Testov");
        $("[id=userEmail]").setValue("test@test.com");
        /*$("[id=gender-radio-1").click();*/

        $("[id=userNumber]").setValue("1234567890");

        $("[id=currentAddress]").setValue("Test № 1");

        /*$("[id=currentAddress]").setValue("Some address 1");
        $("[id=permanentAddress]").setValue("Another address 2");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text("Alex"), text("alex@egorov.com"),
                text("Some address 1"), text("Another address 2"));*/
    }
}
