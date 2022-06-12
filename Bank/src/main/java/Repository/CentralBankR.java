package Repository;

import Entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
/*
    public String selectUsername(CentralBankE centralBankE) throws Exception {
        String dbusername = null;
        preparedStatement = connection.prepareStatement("SELECT *FROM `central bank` WHERE username = ?");
        try {
            preparedStatement.setString(1, centralBankE.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                dbusername = resultSet.getString("username");
            }
        }catch (Exception exception){
            throw new BankException("System Error");
        }

        return dbusername;
    }
*/
    public String selectPassword(CustomerE customerE) throws Exception {
        preparedStatement = connection.prepareStatement("SELECT *FROM `central bank` WHERE username = ?");
        preparedStatement.setString(1, customerE.getNationalCode());
        ResultSet resultSet = preparedStatement.executeQuery();

        String dbpass = null;
        while (resultSet.next()) {
            dbpass = resultSet.getString("password");
        }
        //customerE.setPassword(dbpass);
        return dbpass;
    }

    public void commit() throws Exception{
        connection.commit();;
    }
    public  void close() throws Exception{
        preparedStatement.close();
        connection.close();
    }

}
