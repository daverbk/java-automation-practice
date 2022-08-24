package models;

import java.io.File;
import java.time.LocalDateTime;

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
    public LocalDateTime dateOfBirth;
    public String[] subjects;
    public String[] hobbies;

    public Person(String name, String surname, String email, String phoneNumber,
                  String currentAddress, File photo, String city, String state,
                  String gender, LocalDateTime dateOfBirth, String[] subjects,
                  String[] hobbies) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.currentAddress = currentAddress;
        this.photo = photo;
        this.city = city;
        this.state = state;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.subjects = subjects;
        this.hobbies = hobbies;
    }
}
