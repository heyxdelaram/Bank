public class HouseLoanE {
    private long id;
    private long customerId;
    private String type;
    private String loanStatus;
    private double loanAmount;
    private String installmentStatus;
    private String installmentsType;
    public HouseLoanE(long id,long customerId,String type,String loanStatus,double loanAmount,String installmentsType,String installmentStatus){
        this.id=id;
        this.customerId=customerId;
        this.type=type;
        this.loanStatus=loanStatus;
        this.loanAmount=loanAmount;
        this.installmentStatus=installmentStatus;
        this.installmentsType=installmentsType;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getInstallmentStatus() {
        return installmentStatus;
    }

    public void setInstallmentStatus(String installmentStatus) {
        this.installmentStatus = installmentStatus;
    }

    public String getInstallmentsType() {
        return installmentsType;
    }

    public void setInstallmentsType(String installmentsType) {
        this.installmentsType = installmentsType;
    }

    public HouseLoanE(){
    }
}
