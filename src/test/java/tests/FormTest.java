package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.tagName;
import static org.openqa.selenium.By.xpath;

public class FormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest() {

        File userPicture = new File("/Users/david/Downloads/123.jpeg");
        Person person = new Person("Alex", "Alexander", "aalex@gmail.com",
                "1231123532", "Address 10. 2012 house 21", userPicture,
                "Delhi", "NCR");

        open("/automation-practice-form");
        clearBanners();
        populateForm(person);

        $(tagName("table")).shouldHave(text(person.city), text(person.currentAddress), text(person.personName), text(person.state),
                text(person.email), text(person.personSurname), text(person.state), text(person.userPicture.getName()), text(person.phoneNumber));
    }

    private void clearBanners() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    private void populateForm(Person person) {

        $("#firstName").setValue(person.personName);
        $("#lastName").setValue(person.personSurname);
        $("#userEmail").setValue(person.email);
        $("#genterWrapper #gender-radio-1 + label").click();
        $("#userNumber").setValue(person.phoneNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker [aria-label='Choose Wednesday, August 17th, 2022']").click();

        $("#subjectsContainer input").sendKeys("English");
        $(".subjects-auto-complete__menu #react-select-2-option-0").click();
        $("#hobbiesWrapper #hobbies-checkbox-1 + label").click();

        $("#uploadPicture").uploadFile(person.userPicture);

        $("#currentAddress").setValue(person.currentAddress);

        $("#state").click();
        $(xpath(String.format("//*[@id='state']//*[contains(text(), '%s')]", person.state))).click();

        $("#city").click();
        $(xpath(String.format("//*[@id='city']//*[contains(text(), '%s')]", person.city))).click();

        $("#submit").click();
    }
}

class Person {
    String personName;
    String personSurname;
    String email;
    String phoneNumber;
    String currentAddress;
    String city;
    String state;
    File userPicture;

    public Person(String personName, String personSurname, String email, String phoneNumber,
                  String currentAddress, File userPicture, String city, String state) {

        this.personName = personName;
        this.personSurname = personSurname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.currentAddress = currentAddress;
        this.userPicture = userPicture;
        this.city = city;
        this.state = state;
    }
}
