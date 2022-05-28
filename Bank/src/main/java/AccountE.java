public class AccountE{
    private long id;
    private long number;
    private String type;
    private double deposit;
    private long customerId;
    public AccountE(long id,long number,String type,double deposit,long customerId){
        this.id=id;
        this.number=number;
        this.type=type;
        this.deposit=deposit;
        this.customerId=customerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public AccountE(){}
}
