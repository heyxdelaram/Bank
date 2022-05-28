public class TransactionE {
    private long id;
    private long cardId;
    private long destinationCardNumber;
    private double amount;
    private String date;
    private String time;
    private long loanId;
    public TransactionE(long id,long cardId,long destinationCardNumber,double amount,String date,String time,long loanId){
        this.id=id;
        this.cardId=cardId;
        this.destinationCardNumber=destinationCardNumber;
        this.amount=amount;
        this.date=date;
        this.time=time;
        this.loanId=loanId;
    }
    public TransactionE(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public long getDestinationCardNumber() {
        return destinationCardNumber;
    }

    public void setDestinationCardNumber(long destinationCardNumber) {
        this.destinationCardNumber = destinationCardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
    }
}
