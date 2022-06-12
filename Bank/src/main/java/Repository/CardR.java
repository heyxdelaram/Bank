package Repository;

import Entity.CardE;
import Entity.CustomerE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CardR implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public CardR() throws Exception{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1073");
        connection.setAutoCommit(false);
    }

    public void insert(CardE cardE) throws Exception {
        preparedStatement = connection.prepareStatement("INSERT INTO cards (cards_id, customer_id, card_number, issuance_date, expiry_date, cvv2) VALUES (?,?,?,?,?,?)");

        preparedStatement.setLong(1, cardE.getId());
        preparedStatement.setLong(2, cardE.getCustomerId());
        preparedStatement.setString(3, cardE.getCardNumber());
        preparedStatement.setString(4, cardE.getIssuanceDate());
        preparedStatement.setString(5, cardE.getExpirationDate());
        preparedStatement.setInt(6, cardE.getCvv2());
        preparedStatement.executeUpdate();
    }

    public void update(CardE cardE) throws Exception{
        preparedStatement = connection.prepareStatement("UPDATE cards SET customer_id = ?, card_number = ?, issuance_date = ?, expiry_date = ?, cvv2 = ? WHERE cards_id = ?");

        preparedStatement.setLong(1, cardE.getCustomerId());
        preparedStatement.setString(2, cardE.getCardNumber());
        preparedStatement.setString(3, cardE.getIssuanceDate());
        preparedStatement.setString(4, cardE.getExpirationDate());
        preparedStatement.setInt(5, cardE.getCvv2());
        preparedStatement.executeUpdate();
    }

    public void delete(long id) throws Exception{
        preparedStatement = connection.prepareStatement("DELETE FROM cards WHERE cards_id = ?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    public List<CardE> select() throws Exception{
        preparedStatement = connection.prepareStatement("SELECT *FROM cards");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<CardE> cardEList = new ArrayList<>();
        while (resultSet.next()){
            CardE cardE = new CardE();
            cardE.setId(resultSet.getLong("cards_id"));
            cardE.setCustomerId(resultSet.getLong("customer_id"));
            cardE.setCardNumber(resultSet.getString("card_number"));
            cardE.setIssuanceDate(resultSet.getString("issuance_date"));
            cardE.setExpirationDate(resultSet.getString("expiry_date"));
            cardE.setCvv2(resultSet.getInt("cvv2"));

        }
        return cardEList;
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
