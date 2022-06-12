package Entity;

public class AccountE{
    private long id;
    private String accountNumber;
    private long customerId;
    private String accountType;
    private double balance;
    //private int loanStatus;
    public AccountE(long id, String accountNumber, long customerId, String accountType, double balance){
        this.id = id;
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
        //this.loanStatus = loanStatus;
    }

    public long getId() {
        return id;
    }

    public AccountE setId(long id) {
        this.id = id;
        return this;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public AccountE setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public long getCustomerId() {
        return customerId;
    }

    public AccountE setCustomerId(long customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getAccountType() {
        return accountType;
    }

    public AccountE setAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public double getBalance() {
        return balance;
    }

    public AccountE setBalance(double balance) {
        this.balance = balance;
        return this;
    }
   /* public int getLoanStatus() {
        return loanStatus;
    }

    public AccountE setLoanStatus(int loanStatus) {
        this.loanStatus = loanStatus;
        return this;
    }*/

    public AccountE(){}
}