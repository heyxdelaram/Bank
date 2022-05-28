public class StaffE {
    private long id;
    private String name;
    private long nId;
    private String father;
    private String dateOfBirth;
    private long cellNumber;
    private long homeNumber;
    private String address;
    private String status;
    private long salary;
    private String username;
    private String password;
    public void StaffE(long id,String name, long nId, String father, String dateOfBirth, long cellNumber,long homeNumber,String address, String username,String status, long salary,String password){
        this.id=id;
        this.address=address;
        this.cellNumber=cellNumber;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
        this.father=father;
        this.homeNumber=homeNumber;
        this.nId=nId;
        this.password=password;
        this.salary=salary;
        this.status=status;
        this.username=username;
    }
    public StaffE(){}

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

    public long getnId() {
        return nId;
    }

    public void setnId(long nId) {
        this.nId = nId;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(long cellNumber) {
        this.cellNumber = cellNumber;
    }

    public long getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(long homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

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
}
