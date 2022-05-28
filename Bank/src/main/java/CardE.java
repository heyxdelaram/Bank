public class CardE {
    private long id;
    private long customerId;
    private long number;
    private String issuanceDate;
    private String expirationDate;
    private int cvv2;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public CardE(long id, long number, long customerId, String issuanceDate, String expirationDate, int cvv2, double balance){
        this.id=id;
        this.customerId=customerId;
        this.number=number;
        this.issuanceDate=issuanceDate;
        this.expirationDate=expirationDate;
        this.cvv2=cvv2;
        this.balance=balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getIssuanceDate() {
        return issuanceDate;
    }

    public void setIssuanceDate(String issuanceDate) {
        this.issuanceDate = issuanceDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvv2() {
        return cvv2;
    }

    public void setCvv2(int cvv2) {
        this.cvv2 = cvv2;
    }

    public CardE(){}
}
