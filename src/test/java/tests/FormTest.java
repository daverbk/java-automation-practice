package tests;

import models.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.FormPage;
import services.FileFromResourceUploader;

import java.io.File;
import java.net.URISyntaxException;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.tagName;

public class FormTest extends TestBase {

    private static FormPage formPage;
    private static Person person;

    @BeforeAll
    public static void beforeAll() throws URISyntaxException {

        formPage = new FormPage();
        File userPhoto = new FileFromResourceUploader().getFileFromResource("123.jpeg");

        person = new Person(
                userPhoto,
                "Delhi",
                "NCR",
                "Male",
                new String[]{"English", "Hindi"},
                new String[]{"Reading", "Music"});
    }

    @Test
    public void formTest() {

        open("/automation-practice-form");
        removeBanners();

        formPage.setFirstName(person.name)
                .setSurname(person.surname)
                .setEmail(person.email)
                .setNumber(person.phoneNumber)
                .setGender(person.gender)
                .setDateOfBirth(person.dateOfBirth)
                .setSubjects(person.subjects)
                .setHobbies(person.hobbies)
                .uploadPicture(person.photo)
                .setAddress(person.currentAddress)
                .setState(person.state)
                .setCity(person.city)
                .submitForm();

        $(tagName("table")).shouldHave(
                text(person.name),
                text(person.surname),
                text(person.email),
                text(person.phoneNumber),
                text(person.currentAddress),
                text(person.state),
                text(person.city),
                text(person.gender),
                text(String.join(", ", person.hobbies)),
                text(String.join(", ", person.subjects)),
                text(person.dateOfBirth.format(DateTimeFormatter.ofPattern("dd MMMM,yyyy"))),
                text(person.photo.getName()));
    }

    private void removeBanners() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }
}

