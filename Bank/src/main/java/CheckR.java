package Repository;

import Entity.CheckE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CheckR {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public CheckR() throws Exception{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1073");
        connection.setAutoCommit(false);
    }

    public void insert(CheckE checkE) throws Exception{
        preparedStatement = connection.prepareStatement("INSERT INTO checks (check_id, payee_id, amount_in_numbers, amount_in_words, for_id, account_number, current_date) VALUES (?,?,?,?,?,?,?)");

        preparedStatement.setLong(1, checkE.getId());
        preparedStatement.setLong(2, checkE.getPayeeId());
        preparedStatement.setDouble(3, checkE.getAmountInNumbers());
        preparedStatement.setString(4,checkE.getAmountInWords());
        preparedStatement.setLong(5, checkE.getForId());
        preparedStatement.setLong(6, checkE.getAccountNumber());
        preparedStatement.setString(7, checkE.getCurrentDate());
        preparedStatement.executeUpdate();
    }

    public void update(CheckE checkE) throws Exception{
        preparedStatement = connection.prepareStatement("UPDATE checks SET check_id = ?, payee_id = ?, amount_in_numbers = ?, amount_in_words = ?, for_id = ?, account_number = ?, current_date = ?");

        preparedStatement.setLong(1, checkE.getPayeeId());
        preparedStatement.setDouble(2, checkE.getAmountInNumbers());
        preparedStatement.setString(3, checkE.getAmountInWords());
        preparedStatement.setLong(4, checkE.getForId());
        preparedStatement.setLong(5, checkE.getAccountNumber());
        preparedStatement.setString(6, checkE.getCurrentDate());
        preparedStatement.setLong(7, checkE.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(long id) throws Exception{
        preparedStatement = connection.prepareStatement("DELETE FROM checks WHERE check_id = ?");
        preparedStatement.setLong(1,id);
        preparedStatement.executeUpdate();
    }
    public List<CheckE> select() throws Exception{
        preparedStatement = connection.prepareStatement("SELECT *FROM checks");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<CheckE> checkEList = new ArrayList<>();

        while (resultSet.next()){
            CheckE checkE = new CheckE();
            checkE.setId(resultSet.getLong("check_id"));
            checkE.setForId(resultSet.getLong("payee_id"));
            checkE.setAmountInNumbers(resultSet.getDouble("amount_in_numbers"));
            checkE.setAmountInWords(resultSet.getString("amount_in_words"));
            checkE.setForId(resultSet.getLong("for_id"));
            checkE.setCurrentDate(resultSet.getString("current_id"));
        }
        return checkEList;
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

