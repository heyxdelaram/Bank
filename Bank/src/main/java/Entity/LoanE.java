package Entity;

public class LoanE {
    private long id;
    private long customerId;
    private String type;
    private double loanAmount;
    private String installmentType;
    private int installmentStatus;
    private int onLoan;
    public LoanE(long id, long customerId, String type, double loanAmount, String installmentType, int installmentStatus, int onLoan){

        this.id = id;
        this.customerId = customerId;
        this.type = type;
        this.loanAmount = loanAmount;
        this.installmentType = installmentType;
        this.installmentStatus = installmentStatus;
        this.onLoan = onLoan;
    }

    public long getId() {
        return id;
    }

    public LoanE setId(long id) {
        this.id = id;
        return this;
    }

    public long getCustomerId() {
        return customerId;
    }

    public LoanE setCustomerId(long customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getType() {
        return type;
    }

    public LoanE setType(String type) {
        this.type = type;
        return this;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public LoanE setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
        return this;
    }

    public String getInstallmentType() {
        return installmentType;
    }

    public LoanE setInstallmentType(String installmentType) {
        this.installmentType = installmentType;
        return this;
    }

    public int getInstallmentStatus() {
        return installmentStatus;
    }

    public LoanE setInstallmentStatus(int installmentStatus) {
        this.installmentStatus = installmentStatus;
        return this;
    }

    public int getOnLoan() {
        return onLoan;
    }

    public LoanE setOnLoan(int onLoan) {
        this.onLoan = onLoan;
        return this;
    }

    public LoanE(){
    }
}