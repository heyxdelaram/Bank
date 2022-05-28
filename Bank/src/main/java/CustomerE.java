public class CustomerE {
    private long id;
    private String name;
    private long nID;
    private String father;
    private long cellNumber;
    private String address;
    private long homeNumber;
    private String email;
    private String dateOfBirth;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void CustomerE(long id, long nID, String name, String father, long cellNumber, String address, long homeNumber, String email, String dateOfBirth, String username, String password) {
        this.id = id;
        this.name = name;
        this.nID = nID;
        this.father = father;
        this.cellNumber = cellNumber;
        this.address = address;
        this.homeNumber = homeNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.username=username;
        this.password=password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getnID() {
        return nID;
    }

    public void setnID(long nID) {
        this.nID = nID;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public long getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(long cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(long homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public CustomerE(){}
}
