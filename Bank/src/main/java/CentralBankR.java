package Repository;

import Entity.CentralBankE;
import Entity.CheckE;
import Entity.TransactionE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class CentralBankR {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public CentralBankR() throws Exception{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1073");
        connection.setAutoCommit(false);
    }

    public void select(String tableName) throws Exception{
        switch (tableName){
            case "accounts":
                AccountR accountR = new AccountR();
                accountR.select();
            case "cards":
                CardR cardR = new CardR();
                cardR.select();
            case "checks":
                CheckR checkR = new CheckR();
                checkR.select();
            case "customers":
                CustomersR customersR = new CustomersR();
                customersR.select();
            case "loans":
                LoanR loanR = new LoanR();
                loanR.select();
            case "staff":
                StaffR staffR = new StaffR();
                staffR.select();
            case "transactions":
                TransactionR transactionR = new TransactionR();
                transactionR.select();
        }
    }
    public void commit() throws Exception{
        connection.commit();;
    }
    public  void close() throws Exception{
        preparedStatement.close();
        connection.close();
    }

}
