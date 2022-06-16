package Repository;

import Entity.CustomerE;
import Entity.StaffE;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StaffR implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public StaffR() throws Exception {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1073");
        connection.setAutoCommit(false);
    }



    public void insert(StaffE staffE) throws Exception {
        preparedStatement = connection.prepareStatement("INSERT INTO staff (staff_id, first_name, last_name, father_name, national_code, cell_phone, address, city, birth_date, position, salary, username, password) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

        preparedStatement.setLong(1, staffE.getId());
        preparedStatement.setString(2, staffE.getFirstName());
        preparedStatement.setString(3, staffE.getLastName());
        preparedStatement.setString(4, staffE.getFatherName());
        preparedStatement.setString(5, staffE.getNationalCode());
        preparedStatement.setString(6, staffE.getCellPhone());
        preparedStatement.setString(7, staffE.getAddress());
        preparedStatement.setString(8, staffE.getCity());
        preparedStatement.setString(9, staffE.getDateOfBirth());
        preparedStatement.setString(10, staffE.getPosition());
        preparedStatement.setDouble(11, staffE.getSalary());
        preparedStatement.setString(12, staffE.getUsername());
        preparedStatement.setString(13, staffE.getPassword());
        preparedStatement.executeUpdate();
    }

    public void update(StaffE staffE) throws Exception{
        preparedStatement = connection.prepareStatement("UPDATE staff SET first_name = ?, last_name = ?, father_name = ?, national_code = ?, cell_phone = ?, address = ?, city = ?, birth_date = ?, position = ?, salary = ?, username = ?, password = ? WHERE staff_id = ?");

        preparedStatement.setString(1, staffE.getFirstName());
        preparedStatement.setString(2, staffE.getLastName());
        preparedStatement.setString(3, staffE.getFatherName());
        preparedStatement.setString(4, staffE.getNationalCode());
        preparedStatement.setString(5, staffE.getCellPhone());
        preparedStatement.setString(6, staffE.getAddress());
        preparedStatement.setString(7, staffE.getCity());
        preparedStatement.setString(8, staffE.getDateOfBirth());
        preparedStatement.setString(9, staffE.getPosition());
        preparedStatement.setDouble(10, staffE.getSalary());
        preparedStatement.setString(11, staffE.getUsername());
        preparedStatement.setString(12, staffE.getPassword());
        preparedStatement.setLong(9, staffE.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(long id) throws Exception{
        preparedStatement = connection.prepareStatement("DELETE FROM staff WHERE staff_id = ?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    public void selectUsername(StaffE staffE) throws Exception {
        preparedStatement = connection.prepareStatement("SELECT username FROM staff WHERE username = ?");

        try {
            try {
                preparedStatement.setString(1, staffE.getUsername());
            }catch (Exception e){
                throw new Exception("System Error");
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            String dbusername = null;
            while (resultSet.next()) {
                dbusername = resultSet.getString("username");
                staffE.setUsername(dbusername);
            }
        }catch (Exception exception){
            staffE.setUsername(null);
        }
    }

    public void selectPassword(StaffE staffE) throws Exception {
        preparedStatement = connection.prepareStatement("SELECT password, username FROM staff WHERE username = ?");
        try {
            preparedStatement.setString(1, staffE.getUsername());
        }catch (Exception exception){
            throw new Exception("System Error");
        }

        ResultSet resultSet = preparedStatement.executeQuery();
        String dbpass = null;
        while (resultSet.next()) {
            dbpass = resultSet.getString("password");
            staffE.setPassword(dbpass);
        }
    }

    public List<StaffE> select() throws Exception{
        preparedStatement = connection.prepareStatement("SELECT *FROM staff;");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<StaffE> staffEList = new ArrayList<>();
        while (resultSet.next()){
            StaffE staffE = new StaffE();
            staffE.setId(resultSet.getLong("staff_id"));
            staffE.setFirstName(resultSet.getString("first_name"));
            staffE.setLastName(resultSet.getString("last_name"));
            staffE.setFatherName(resultSet.getString("father_name"));
            staffE.setNationalCode(resultSet.getString("national_code"));
            staffE.setCellPhone(resultSet.getString("cell_phone"));
            staffE.setAddress(resultSet.getString("address"));
            staffE.setCity(resultSet.getString("city"));
            staffE.setDateOfBirth(resultSet.getString("birth_date"));
            staffE.setPosition(resultSet.getString("position"));
            staffE.setSalary(resultSet.getDouble("salary"));
            staffE.setUsername(resultSet.getString("username"));
            staffE.setPassword(resultSet.getString("password"));
        }
        return staffEList;
    }

    public int selectRowNum() throws Exception {
        int count = 0;
        try {
            preparedStatement = connection.prepareStatement("SELECT count(*) FROM staff");
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

