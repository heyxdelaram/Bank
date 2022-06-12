package Repository;

import Entity.AccountE;
import Entity.CardE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountR implements AutoCloseable {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public AccountR() throws Exception{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1073");
        connection.setAutoCommit(false);
    }

    public void insert(AccountE accountE) throws Exception {
        preparedStatement = connection.prepareStatement("INSERT INTO accounts (account_id, account_number, customer_id, account_type, balance, loan_status) VALUES (?,?,?,?,?,?)");

        preparedStatement.setLong(1, accountE.getId());
        preparedStatement.setString(2, accountE.getAccountNumber());
        preparedStatement.setLong(3, accountE.getCustomerId());
        preparedStatement.setString(4, accountE.getAccountType());
        preparedStatement.setDouble(5, accountE.getBalance());
        //preparedStatement.setInt(6, accountE.getLoanStatus());
        preparedStatement.executeUpdate();
    }

    public void update(AccountE accountE) throws Exception{
        preparedStatement = connection.prepareStatement("UPDATE accounts SET account_number = ?, customer_id = ?, account_type = ?, balance = ?, loan_status = ? WHERE account_id = ?");

        preparedStatement.setString(1, accountE.getAccountNumber());
        preparedStatement.setLong(2, accountE.getCustomerId());
        preparedStatement.setString(3, accountE.getAccountType());
        preparedStatement.setDouble(4, accountE.getBalance());
        //preparedStatement.setInt(5, accountE.getLoanStatus());
        preparedStatement.setLong(6, accountE.getId());

        preparedStatement.executeUpdate();
    }

    public void delete(long id) throws Exception{
        preparedStatement = connection.prepareStatement("DELETE FROM accounts WHERE accounts_id = ?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    public List<AccountE> select() throws Exception{
        preparedStatement = connection.prepareStatement("SELECT *FROM accounts");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<AccountE> accountEList = new ArrayList<>();
        while (resultSet.next()){
            AccountE accountE = new AccountE();
            accountE.setId(resultSet.getLong("account_id"));
            accountE.setAccountNumber(resultSet.getString("account_number"));
            accountE.setCustomerId(resultSet.getLong("customer_id"));
            accountE.setAccountType(resultSet.getString("account_type"));
            accountE.setBalance(resultSet.getDouble("balance"));
            //accountE.setLoanStatus(resultSet.getInt("loan_status"));
        }
        return accountEList;
    }
    
    public int selectRowNum() throws Exception {
        int count = 0;
        try {
            preparedStatement = connection.prepareStatement("SELECT count(*) FROM accounts");
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
    public  void close() throws Exception{
        preparedStatement.close();
        connection.close();
    }
}

