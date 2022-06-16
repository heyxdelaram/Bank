package Repository;

import Entity.CardE;
import Entity.LoanE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoanR implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public LoanR() throws Exception{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1073");
        connection.setAutoCommit(false);
    }

    public void insert(LoanE loanE) throws Exception{
        preparedStatement = connection.prepareStatement("INSERT INTO loans (loan_id, customer_id, loan_type, amount, installment_type, installment_status, on_loan) VALUES (?,?,?,?,?,?,?)");

        preparedStatement.setLong(1, loanE.getId());
        preparedStatement.setLong(2, loanE.getCustomerId());
        preparedStatement.setString(3, loanE.getType());
        preparedStatement.setDouble(4, loanE.getLoanAmount());
        preparedStatement.setString(5, loanE.getInstallmentType());
        preparedStatement.setInt(6, loanE.getInstallmentStatus());
        preparedStatement.setInt(7, loanE.getOnLoan());
        preparedStatement.executeUpdate();

    }

    public void update(LoanE loanE) throws Exception{
        preparedStatement = connection.prepareStatement("UPDATE loans SET customer_id = ?, loan_type = ?, amount = ?, installment_type = ?, installment_status = ?, on_loan = ? WHERE loan_id = ?");

        preparedStatement.setLong(1, loanE.getCustomerId());
        preparedStatement.setString(2, loanE.getType());
        preparedStatement.setDouble(3, loanE.getLoanAmount());
        preparedStatement.setString(4, loanE.getInstallmentType());
        preparedStatement.setInt(5, loanE.getInstallmentStatus());
        preparedStatement.setInt(6, loanE.getOnLoan());
        preparedStatement.setLong(7, loanE.getId());

        preparedStatement.executeUpdate();
    }

    public void delete(long id) throws Exception{
        preparedStatement = connection.prepareStatement("DELETE FROM loans WHERE loans_id = ?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    public List<LoanE> select() throws Exception{
        preparedStatement = connection.prepareStatement("SELECT *FROM loans");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<LoanE> loanEList = new ArrayList<>();
        while (resultSet.next()){

            LoanE loanE = new LoanE();
            loanE.setId(resultSet.getLong("loan_id"));
            loanE.setId(resultSet.getLong("customer_id"));
            loanE.setType(resultSet.getString("loan_type"));
            loanE.setLoanAmount(resultSet.getDouble("amount"));
            loanE.setInstallmentType(resultSet.getString("installment_type"));
            loanE.setInstallmentStatus(resultSet.getInt("installment_status"));
            loanE.setOnLoan(resultSet.getInt("on_loan"));
        }
        return loanEList;
    }

    public int selectRowNum() throws Exception {
        int count = 0;
        try {
            preparedStatement = connection.prepareStatement("SELECT count(*) FROM loans");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //count++;
                count = resultSet.getInt(1);
            }
        } catch (Exception e) {

        }

        return count;
    }

    public void commit() throws Exception{
        connection.commit();;
    }
    public void rollback() throws Exception{
        connection.rollback();
    }

    //bc of autocloseable that is false
    public  void close() throws Exception{
        preparedStatement.close();
        connection.close();
    }
}