package Entity;

import java.util.Date;

public class CustomerE {
    private long id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String nationalCode;
    private String password;
    private String cellPhone;
    private String address;
    private String city;
    private String dateOfBirth;

    public void CustomerE(long id, String firstName, String lastName, String fatherName, String nationalCode, String cellPhone, String address, String city, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.nationalCode = nationalCode;
        this.cellPhone = cellPhone;
        this.address = address;
        this.city = city;
        this.dateOfBirth = this.dateOfBirth;
    }

    public long getId() {
        return id;
    }

    public CustomerE setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CustomerE setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomerE setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public CustomerE setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public CustomerE setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CustomerE setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public CustomerE setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CustomerE setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public CustomerE setCity(String city) {
        this.city = city;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public CustomerE setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public CustomerE(){}
}