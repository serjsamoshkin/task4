package ua.testing.task4.model.entity.questionnaire;

import ua.testing.task4.model.annotation.Bundle;
import ua.testing.task4.model.annotation.Ref;
import ua.testing.task4.model.entity.group.Group;
import ua.testing.task4.model.entity.address.Address;

import java.util.Date;

public class Questionnaire<Questionnaire> {

    @Bundle(name = "lastName_Questionnaire_field")
    private String lastName;

    @Bundle(name = "firstName_Questionnaire_field")
    private String firstName;

    @Bundle(name = "patronymic_Questionnaire_field")
    private String patronymic;

    @Bundle(name = "nickName_Questionnaire_field")
    private String nickName;

    @Bundle(name = "homePhoneNumber_Questionnaire_field")
    private String homePhoneNumber;

    @Bundle(name = "secondMobilePhoneNumber_Questionnaire_field")
    private String secondMobilePhoneNumber;

    @Bundle(name = "group_Questionnaire_field")
    @Ref(clazz = Group.class)
    private Group group;

    @Bundle(name = "email_Questionnaire_field")
    private String email;

    @Bundle(name = "skype_Questionnaire_field")
    private String skype;

    @Bundle(name = "address_Questionnaire_field")
    @Ref(clazz = Address.class)
    private Address address;

    Date addDate;
    Date updateDate;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public String getSecondMobilePhoneNumber() {
        return secondMobilePhoneNumber;
    }

    public void setSecondMobilePhoneNumber(String secondMobilePhoneNumber) {
        this.secondMobilePhoneNumber = secondMobilePhoneNumber;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    @Override
    public String toString() {
        // TODO перевести на бандл!
        return "Questionnaire{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", nickName='" + nickName + '\'' +
                ", homePhoneNumber='" + homePhoneNumber + '\'' +
                ", secondMobilePhoneNumber='" + secondMobilePhoneNumber + '\'' +
                ", group=" + group +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                ", address=" + address +
                ", addDate=" + addDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
