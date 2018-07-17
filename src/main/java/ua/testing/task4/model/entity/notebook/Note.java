package ua.testing.task4.model.entity.notebook;

import ua.testing.task4.view.annotation.Bundle;
import ua.testing.task4.view.annotation.Ref;

import java.util.Date;
import java.util.Objects;

/**
 * Entity Note
 */
public class Note {

    @Bundle(key = "note.field.lastName")
    private String lastName;

    @Bundle(key = "note.field.firstName")
    private String firstName;

    @Bundle(key = "note.field.patronymic")
    private String patronymic;

    @Bundle(key = "note.field.nickName")
    private String nickName;

    @Bundle(key = "note.field.comment")
    private String comment;

    @Bundle(key = "note.field.group")
    @Ref(clazz = Group.class)
    private Group group;

    @Bundle(key = "note.field.homePhoneNumber")
    private String homePhoneNumber;

    @Bundle(key = "note.field.mobilePhoneNumber")
    private String mobilePhoneNumber;

    @Bundle(key = "note.field.secondMobilePhoneNumber")
    private String secondMobilePhoneNumber;

    @Bundle(key = "note.field.email")
    private String email;

    @Bundle(key = "note.field.skype")
    private String skype;

    @Bundle(key = "note.field.address")
    @Ref(clazz = Address.class)
    private Address address;

    private Date addDate;
    private Date updateDate;


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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
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
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        Note eqObj = (Note) obj;
        //Objects.equals is: (firstName == eqObj.firstName) || (firstName != null && firstName.equals(eqObj.firstName)
        return Objects.equals(firstName, eqObj.firstName) &&
                Objects.equals(lastName, eqObj.lastName) &&
                Objects.equals(patronymic, eqObj.patronymic) &&
                Objects.equals(nickName, eqObj.nickName) &&
                /* хранить в БД группу в виде Enum было бы странно, скорее уже это будет ссылка на связанную таблицу
                и Enum будет связан по имени с записями табилцы, например метод getValue() Enum'a будет возвращать
                ссылку на entity, но это так, мысли на будущее.
                К чему это я - писать просто равно тут, хоть сейчас это и Enum, я не вижу смысла, так как предполагаю
                возможность рефакторинга.
                 */
                Objects.equals(group, eqObj.group) &&
                Objects.equals(homePhoneNumber, eqObj.homePhoneNumber) &&
                Objects.equals(mobilePhoneNumber, eqObj.mobilePhoneNumber) &&
                Objects.equals(email, eqObj.email) &&
                Objects.equals(skype, eqObj.skype) &&
                Objects.equals(address, eqObj.address);


    }


    @Override
    public int hashCode() {

        // Длинный и тяжело поддерживаемый вариант
//        int result = 31 * (31 * (31 + (lastName == null ? 0 : lastName.hashCode()) + (firstName == null ? 0 : firstName.hashCode()))) + (patronymic == null ? 0 : patronymic.hashCode());


        // Ну в общем как Objects.hash, удобный класс, только юзать можно только с Java 1.7.
//        Object[] values = new Object[10];
//
//        values[0] = firstName;
//        values[1] = lastName;
//        values[2] = patronymic;
//        values[3] = nickName;
//        values[4] = group;
//        values[5] = homePhoneNumber;
//        values[6] = mobilePhoneNumber;
//        values[7] = email;
//        values[8] = skype;
//        values[9] = address;
//
//        int result = 1;
//
//        for (int i = 0; i < values.length; i++) {
//            result = 31 * result + (values[i] == null ? 0 : values[i].hashCode());
//        }

        return Objects.hash(getLastName(),
                getFirstName(),
                getPatronymic(),
                getNickName(),
                getGroup(),
                getHomePhoneNumber(),
                getMobilePhoneNumber(),
                getEmail(),
                getSkype(),
                getAddress());
    }

    @Override
    public String toString() {

        return "Note{" +
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
