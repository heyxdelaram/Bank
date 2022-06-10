package Entity;

public class TransactionE {
    private long id;
    private long fromId;
    private long toId;
    private double amount;
    private long loanId;
    private long checkId;
    private String time;
    private String date;
    public TransactionE(long id, long fromId, long toId, double amount, long loanId, long checkId, String time, String date){
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
        this.loanId = loanId;
        this.checkId = checkId;
        this.time = time;
        this.date = date;
    }
    public TransactionE(){}

    public long getId() {
        return id;
    }

    public TransactionE setId(long id) {
        this.id = id;
        return this;
    }

    public long getFromId() {
        return fromId;
    }

    public TransactionE setFromId(long fromId) {
        this.fromId = fromId;
        return this;
    }

    public long getToId() {
        return toId;
    }

    public TransactionE setToId(long toId) {
        this.toId = toId;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionE setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public long getLoanId() {
        return loanId;
    }

    public TransactionE setLoanId(long loanId) {
        this.loanId = loanId;
        return this;
    }

    public long getCheckId() {
        return checkId;
    }

    public TransactionE setCheckId(long checkId) {
        this.checkId = checkId;
        return this;
    }

    public String getTime() {
        return time;
    }

    public TransactionE setTime(String time) {
        this.time = time;
        return this;
    }

    public String getDate() {
        return date;
    }

    public TransactionE setDate(String date) {
        this.date = date;
        return this;
    }
}