package models;

import com.github.javafaker.Faker;

import java.io.File;
import java.time.LocalDate;

public class Person {
    public String name;
    public String surname;
    public String email;
    public String phoneNumber;
    public String currentAddress;
    public String city;
    public String state;
    public File photo;
    public String gender;
    public LocalDate dateOfBirth;
    public String[] subjects;
    public String[] hobbies;

    public Person(File photo, String city, String state, String gender, String[] subjects, String[] hobbies) {

        Faker faker = new Faker();

        this.name = faker.name().firstName();
        this.surname = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.phoneNumber = faker.phoneNumber().subscriberNumber(10);
        this.currentAddress = faker.address().fullAddress();

        this.dateOfBirth = LocalDate.now();

        this.photo = photo;
        this.city = city;
        this.state = state;
        this.gender = gender;
        this.subjects = subjects;
        this.hobbies = hobbies;
    }
}
