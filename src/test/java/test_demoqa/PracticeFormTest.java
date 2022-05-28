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

        open("/automation-practice-form"); // открываем сайт
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=firstName]").setValue("Test"); // ввод имени
        $("[id=lastName]").setValue("Testov"); // ввод фамилии
        $("[id=userEmail]").setValue("test@test.com"); // ввод email
        $("#gender-radio-2").parent().click(); // выбор пола
        $("[id=userNumber]").setValue("1234567890"); // ввод телефона

        $("[id=dateOfBirthInput]").click(); // выбор даты рождения

        $("#hobbies-checkbox-1").parent().click(); // checkbox "Sport"
        $("#hobbies-checkbox-2").parent().click(); // checkbox "Reading"
        $("#hobbies-checkbox-3").parent().click(); // checkbox "Music"

        $("[id=currentAddress]").setValue("Test № 1"); // ввод адреса

        /*$("[id=currentAddress]").setValue("Some address 1");
        $("[id=permanentAddress]").setValue("Another address 2");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text("Alex"), text("alex@egorov.com"),
                text("Some address 1"), text("Another address 2"));*/
    }
}
