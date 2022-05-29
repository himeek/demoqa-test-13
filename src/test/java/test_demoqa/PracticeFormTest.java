package test_demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;

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

        $("#firstName").setValue("Test"); // ввод имени
        $("#lastName").setValue("Testov"); // ввод фамилии
        $("#userEmail").setValue("test@test.com"); // ввод email
        $("#genterWrapper").$(byText("Male")).click(); // выбор пола
        $("#userNumber").setValue("1234567890"); // ввод телефона

        $("#dateOfBirthInput").click(); // открыть выпадающий список (календарь)
        $(".react-datepicker__year-select").selectOption("1980"); // выбор года
        $(".react-datepicker__month-select").selectOption("October"); // выбор месяца
        $(".react-datepicker__day--015").click(); // выбор числа

        $("#subjectsInput").sendKeys("E");
        $(byText("English")).click(); // выбор предмета

        $("#uploadPicture").uploadFile(new File("src/test/resources/text file")); // загрузка файла

        $("#hobbies-checkbox-1").parent().click(); // checkbox "Sport"
        $("#hobbies-checkbox-2").parent().click(); // checkbox "Reading"
        $("#hobbies-checkbox-3").parent().click(); // checkbox "Music"

        $("#currentAddress").setValue("Test adress 1"); // ввод адреса

        $("#state").click();
        $(byText("NCR")).click(); //выбор штата

        $("#city").click();
        $(byText("Delhi")).click(); // выбор города

        $("#submit").click();

        $(".modal-body").shouldHave(
                text("Test Testov"),
                text("test@test.com"),
                text("Male"),
                text("1234567890"),
                text("15 October,1980"),
                text("English"),
                text("Sports, Reading, Music"),
                text("text file"),
                text("Test adress 1"),
                text("NCR Delhi"));
    }
}
