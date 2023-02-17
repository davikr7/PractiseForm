package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";

    private SelenideElement
            titleInput = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            dateInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateAndCity = $("#stateCity-wrapper"),
            stateSelect = $("#state"),
            citySelect = $("#city"),
            submit = $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage checkTitle() {
        titleInput.shouldHave(text(TITLE_TEXT));
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage uploadPicture(String picture) {
        uploadPicture.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateSelect.click();
        stateAndCity.$(byText(state)).click();
        citySelect.click();
        stateAndCity.$(byText(city)).click();
        return this;
    }

    public RegistrationPage submit() {
        submit.click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}
