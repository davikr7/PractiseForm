package demo_qa;

import org.junit.jupiter.api.Test;
import tests.TestBase;

public class RegistrationForm extends TestBase {

    String name = "Boris";
    String surname = "Moiseev";
    String email = "leningrad@gmail.com";
    String gender = "Male";
    String digits = "0987654321";
    String subject = "Computer Science";
    String hobbies = "Sports";
    String address = "Ulitsa Pushkina, dom Kolotushkina";
    String monthOfBirth = "July";
    String yearOfBirth = "1977";
    String dayOfBirth = "03";
    String photo = "image.png";
    String state = "Haryana";
    String city = "Panipat";

    @Test
    void fillRegForm() {

        registrationPage.openPage()
                        .checkTitle()
                        .setFirstName(name)
                        .setLastName(surname)
                        .setEmail(email)
                        .setGender(gender)
                        .setNumber(digits)
                        .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                        .setSubjects(subject)
                        .setHobbies(hobbies)
                        .uploadPicture(photo)
                        .setAddress(address)
                        .setStateAndCity()
                        .submit();

        registrationPage.verifyResultsModalAppears()
                        .verifyResult("Student Name", name + " " + surname)
                        .verifyResult("Student Email", email)
                        .verifyResult("Gender", gender)
                        .verifyResult("Mobile", digits)
                        .verifyResult("Date of Birth", "03 July,1977")
                        .verifyResult("Subjects", subject)
                        .verifyResult("Hobbies", hobbies)
                        .verifyResult("Picture", photo)
                        .verifyResult("Address", address)
                        .verifyResult("State and City", state + " " + city);
    }
}
