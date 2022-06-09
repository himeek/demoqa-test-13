package test_demoqa;

import org.junit.jupiter.api.Test;

public class PracticeFormTestWithPage extends TestBase {

    @Test
    void successfulTest() {

        String firstName = "Test";
        String lastName = "Testov";
        String userEmail = "test@test.com";
        String gender = "Male";
        String userNumber = "1234567890";
        String dayOfBirth = "15";
        String monthOfBirth = "October";
        String yearOfBirth = "1980";
        String subject = "English";
        String fileNamePath = "img/avatar.png";
        String fileName = "avatar.png";
        String hobbie = "Music";
        String currentAddress = "Test adress 1";
        String state = "NCR";
        String city = "Delhi";

        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subject)
                .setUploadFile(fileNamePath)
                .setHobbies(hobbie)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitClick();

        practiceFormPage.checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", userEmail)
                .checkResults("Gender", gender)
                .checkResults("Mobile", userNumber)
                .checkResults("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResults("Subjects", subject)
                .checkResults("Hobbies", hobbie)
                .checkResults("Picture", fileName)
                .checkResults("Address", currentAddress)
                .checkResults("State and City", state + " " + city);

    }
}
