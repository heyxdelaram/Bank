package Entity;

public class StaffE {
    private long id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String nationalCode;
    private String cellPhone;
    private String address;
    private String city;
    private String dateOfBirth;
    private String position;
    private Double salary;
    private String username;
    private String password;
    public void StaffE(long id, String firstName, String lastName, String fatherName, String nationalCode, String cellPhone, String address, String city, String dateOfBirth, String position, Double salary, String username, String password){

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.nationalCode = nationalCode;
        this.cellPhone = cellPhone;
        this.address = address;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.salary = salary;
        this.username = username;
        this.password = password;
    }

    public StaffE(){}

    public long getId() {
        return id;
    }

    public StaffE setId(long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public StaffE setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public StaffE setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public StaffE setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public StaffE setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public StaffE setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public StaffE setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public StaffE setCity(String city) {
        this.city = city;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public StaffE setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public StaffE setPosition(String position) {
        this.position = position;
        return this;
    }

    public Double getSalary() {
        return salary;
    }

    public StaffE setSalary(Double salary) {
        this.salary = salary;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public StaffE setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public StaffE setPassword(String password) {
        this.password = password;
        return this;
    }
}