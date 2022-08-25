package pages;

import services.FirstLetterCapitalization;

import java.io.File;
import java.time.LocalDate;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FormPage {

    public FormPage setFirstName(String personName) {
        $("#firstName").setValue(personName);

        return this;
    }

    public FormPage setSurname(String personLastName) {
        $("#lastName").setValue(personLastName);

        return this;
    }

    public FormPage setEmail(String personEmail) {
        $("#userEmail").setValue(personEmail);

        return this;
    }

    public FormPage setGender(String personGender) {
        $("#genterWrapper").$(byText(personGender)).click();

        return this;
    }

    public FormPage setNumber(String personPhoneNumber) {
        $("#userNumber").setValue(personPhoneNumber);

        return this;
    }

    public FormPage setDateOfBirth(LocalDate personDateOfBirth) {
        String month = new FirstLetterCapitalization().capitalizeFirstLetter(personDateOfBirth.getMonth().toString().toLowerCase());

        $("#dateOfBirthInput").click();

        $(".react-datepicker__year-select").$(byText(String.valueOf(personDateOfBirth.getYear()))).click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__month").$(byText(String.valueOf(personDateOfBirth.getDayOfMonth()))).click();

        return this;
    }

    public FormPage setSubjects(String[] personSubjects) {
        for (String subject : personSubjects) {
            $("#subjectsContainer input").sendKeys(subject);
            $(".subjects-auto-complete__menu").$(byText(subject)).click();
        }

        return this;
    }

    public FormPage setHobbies(String[] personHobbies) {

        for (String hobby : personHobbies) {
            $("#hobbiesWrapper").$(byText(hobby)).click();
        }

        return this;
    }

    public FormPage uploadPicture(File personPhoto) {
        $("#uploadPicture").uploadFile(personPhoto);

        return this;
    }

    public FormPage setAddress(String personAddress) {
        $("#currentAddress").setValue(personAddress);

        return this;
    }

    public FormPage setState(String personState) {
        $("#state").click();
        $("#state").$(byText(personState)).click();

        return this;
    }

    public FormPage setCity(String personCity) {
        $("#city").click();
        $("#city").$(byText(personCity)).click();

        return this;
    }

    public void submitForm() {
        $("#submit").click();
    }
}
