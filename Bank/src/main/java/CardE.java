package Entity;

public class CardE {
    private long id;
    private long customerId;
    private String cardNumber;
    private String issuanceDate;
    private String expirationDate;
    private int cvv2;
    //private double balance;

    public CardE(long id, String cardNumber, long customerId, String issuanceDate, String expirationDate, int cvv2){
        this.id=id;
        this.customerId=customerId;
        this.cardNumber=cardNumber;
        this.issuanceDate=issuanceDate;
        this.expirationDate=expirationDate;
        this.cvv2=cvv2;
        //this.balance=balance;
    }

    public long getId() {
        return id;
    }

    public CardE setId(long id) {
        this.id = id;
        return this;
    }

    public long getCustomerId() {
        return customerId;
    }

    public CardE setCustomerId(long customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public CardE setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public String getIssuanceDate() {
        return issuanceDate;
    }

    public CardE setIssuanceDate(String issuanceDate) {
        this.issuanceDate = issuanceDate;
        return this;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public CardE setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public int getCvv2() {
        return cvv2;
    }

    public CardE setCvv2(int cvv2) {
        this.cvv2 = cvv2;
        return this;
    }

    public CardE(){}
}