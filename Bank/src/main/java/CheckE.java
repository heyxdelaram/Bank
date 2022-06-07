package Entity;

public class CheckE {
    private long id;
    private long payeeId;
    private Double amountInNumbers;
    private String amountInWords;
    private long forId;
    private long accountNumber;
    private String currentDate;


    public CheckE(long id,long payeeId, Double amountInNumbers, String amountInWords, long forId, long accountNumber, String currentDate){
        this.id = id;
        this.payeeId = payeeId;
        this.amountInNumbers = amountInNumbers;
        this.amountInNumbers = amountInNumbers;
        this.forId = forId;
        this.accountNumber = accountNumber;
        this.currentDate = currentDate;
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

    public String getAmountInWords() {
        return amountInWords;
    }

    public CheckE setAmountInWords(String amountInWords) {
        this.amountInWords = amountInWords;
        return this;
    }

    public long getForId() {
        return forId;
    }

    public CheckE setForId(long forId) {
        this.forId = forId;
        return this;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public CheckE setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public CheckE setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
        return this;
    }

    public CheckE(){
    }
}