package Repository;
import Entity.CustomerE;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomersR implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public CustomersR() throws Exception{
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1073");
        connection.setAutoCommit(false);

        //Statement statement = connection.createStatement();
        //statement.executeUpdate("INSERT INTO Customers (customer_id, first_name, last_name, national_code, cell_phone, address, city, birth_date) " + "VALUES (4, 'Riley', 'Ryans', '034-942-9372', '+989198368408', '50 Lillian Crossing', 'Tabriz', '1974-03-21')");
    /*
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customers;");

        while (resultSet.next()){
            System.out.println(resultSet.getString(2));

     */
    }




    public void insert(CustomerE customersE) throws Exception {
        preparedStatement = connection.prepareStatement("INSERT INTO customers (customer_id, first_name, last_name, father_name, national_code, password, cell_phone, address, city, birth_date) VALUES (?,?,?,?,?,?,?,?,?,?)");

        preparedStatement.setLong(1, customersE.getId());
        preparedStatement.setString(2, customersE.getFirstName());
        preparedStatement.setString(3, customersE.getLastName());
        preparedStatement.setString(4, customersE.getFatherName());
        preparedStatement.setString(5, customersE.getNationalCode());
        preparedStatement.setString(6, customersE.getPassword());
        preparedStatement.setString(7, customersE.getCellPhone());
        preparedStatement.setString(8, customersE.getAddress());
        preparedStatement.setString(9, customersE.getCity());
        preparedStatement.setString(10, customersE.getDateOfBirth());
        preparedStatement.executeUpdate();
    }

    public void update(CustomerE customersE) throws Exception{
        preparedStatement = connection.prepareStatement("UPDATE customers SET first_name = ?, last_name = ?, father_name = ?, national_code = ?, password = ?, cell_phone = ?, address = ?, city = ?, birth_date = ? WHERE customer_id = ?");

        preparedStatement.setString(1, customersE.getFirstName());
        preparedStatement.setString(2, customersE.getLastName());
        preparedStatement.setString(3, customersE.getFatherName());
        preparedStatement.setString(4, customersE.getNationalCode());
        preparedStatement.setString(5, customersE.getPassword());
        preparedStatement.setString(6, customersE.getCellPhone());
        preparedStatement.setString(7, customersE.getAddress());
        preparedStatement.setString(8, customersE.getCity());
        preparedStatement.setString(9, customersE.getDateOfBirth());
        preparedStatement.setLong(10, customersE.getId());
        preparedStatement.executeUpdate();
    }
    /*
        public void delete(CustomerE customersE) throws Exception{
            preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE customer_is = ?");

            preparedStatement.setLong(1, customersE.getId());
            preparedStatement.executeUpdate();
        }
    */
    public void selectPassword(CustomerE customerE) throws Exception {
        preparedStatement = connection.prepareStatement("SELECT password, national_code FROM customers WHERE national_code = ?");
        try {
            preparedStatement.setString(1, customerE.getNationalCode());
        }catch (Exception exception){
            throw new Exception("System Error");
        }

        ResultSet resultSet = preparedStatement.executeQuery();
        String dbpass = null;
        while (resultSet.next()) {
            dbpass = resultSet.getString("password");
            customerE.setPassword(dbpass);
        }
    }


    public List<CustomerE> select() throws Exception{
        preparedStatement = connection.prepareStatement("SELECT *FROM customers;");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<CustomerE> customerEList = new ArrayList<>();
        while (resultSet.next()){
            CustomerE customerE = new CustomerE();
            customerE.setId(resultSet.getLong("customer_id"));
            customerE.setFirstName(resultSet.getString("first_name"));
            customerE.setLastName(resultSet.getString("last_name"));
            customerE.setFatherName(resultSet.getString("father_name"));
            customerE.setNationalCode(resultSet.getString("national_code"));
            customerE.setPassword(resultSet.getString("password"));
            customerE.setCellPhone(resultSet.getString("cell_phone"));
            customerE.setAddress(resultSet.getString("address"));
            customerE.setCity(resultSet.getString("city"));
            customerE.setDateOfBirth(resultSet.getString("birth_date"));
        }
        return customerEList;
    }

    public int selectRowNum() throws Exception {
        int count = 0;
        try {
            preparedStatement = connection.prepareStatement("SELECT count(*) FROM customers");
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