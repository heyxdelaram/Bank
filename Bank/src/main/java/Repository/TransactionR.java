package Repository;

import Entity.CardE;
import Entity.TransactionE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionR implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public TransactionR() throws Exception{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1073");
        connection.setAutoCommit(false);
    }

    public void insert(TransactionE transactionE) throws Exception{
        preparedStatement = connection.prepareStatement("INSERT INTO transactions (transaction_id, from_id, to_id, amount, loan_id, check_id, time, date)");

        preparedStatement.setLong(1, transactionE.getId());
        preparedStatement.setLong(2, transactionE.getFromId());
        preparedStatement.setLong(3, transactionE.getToId());
        preparedStatement.setDouble(4, transactionE.getAmount());
        preparedStatement.setLong(5, transactionE.getLoanId());
        preparedStatement.setLong(6, transactionE.getCheckId());
        preparedStatement.setString(7, transactionE.getTime());
        preparedStatement.setString(8, transactionE.getDate());
        preparedStatement.executeUpdate();
    }


    public List<TransactionE> select() throws Exception{
        preparedStatement = connection.prepareStatement("SELECT *FROM transactions");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<TransactionE> transactionEList = new ArrayList<>();
        while (resultSet.next()){

            TransactionE transactionE = new TransactionE();
            transactionE.setId(resultSet.getLong(1));
            transactionE.setFromId(resultSet.getLong(2));
            transactionE.setToId(resultSet.getLong(3));
            transactionE.setAmount(resultSet.getDouble(4));
            transactionE.setLoanId(resultSet.getLong(5));
            transactionE.setCheckId(resultSet.getLong(6));
            transactionE.setTime(resultSet.getString(7));
            transactionE.setDate(resultSet.getString(8));
        }
        return transactionEList;
    }


    public void delete(long id) throws Exception{
        preparedStatement = connection.prepareStatement("DELETE FROM transactions WHERE transaction_id = ?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }


    public void commit() throws Exception{
        connection.commit();;
    }
    public void rollback() throws Exception{
        connection.rollback();
    }

    public  void close() throws Exception{
        preparedStatement.close();
        connection.close();
    }
}
