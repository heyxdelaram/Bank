public class CheckE {
    private long id;
    private long customerId;
    private String expirationDate;
    public CheckE(long id,long customerId,String expirationDate){
        this.id=id;
        this.customerId=customerId;
        this.expirationDate=expirationDate;
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

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public CheckE(){
    }
}
