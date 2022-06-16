package Entity;

public class CheckE {
    private long id;
    private long payeeId;
    private Double amountInNumbers;
    //private String amountInWords;
    private long forId;
    //private long accountNumber;
    private String date;

    public CheckE(long id,long payeeId, Double amountInNumbers, long forId, String currentDate){
        this.id = id;
        this.payeeId = payeeId;
        this.amountInNumbers = amountInNumbers;
        //this.amountInNumbers = amountInNumbers;
        this.forId = forId;
        //this.accountNumber = accountNumber;
        this.date = currentDate;
    }

    public long getId() {
        return id;
    }

    public CheckE setId(long id) {
        this.id = id;
        return this;
    }

    public long getPayeeId() {
        return payeeId;
    }

    public CheckE setPayeeId(long payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    public Double getAmountInNumbers() {
        return amountInNumbers;
    }

    public CheckE setAmountInNumbers(Double amountInNumbers) {
        this.amountInNumbers = amountInNumbers;
        return this;
    }


    public long getForId() {
        return forId;
    }

    public CheckE setForId(long forId) {
        this.forId = forId;
        return this;
    }


    public String getDate() {
        return date;
    }

    public CheckE setDate(String currentDate) {
        this.date = currentDate;
        return this;
    }


    public CheckE(){
    }
}