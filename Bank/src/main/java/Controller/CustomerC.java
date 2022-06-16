package Controller;

import Entity.AccountE;
import Entity.CardE;
import Entity.CustomerE;
import GUI.*;
import Service.AccountS;
import Service.CardS;
import Service.CustomerS;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class CustomerC {
    public void login(String username, String pass) throws Exception{
        //MainMenu mainMenu = new MainMenu();
        try (CustomerLogin customerLogin = new CustomerLogin(new JFrame(), true)){

            CustomerE customerE=new CustomerE();
            customerE.setPassword(pass);

            CustomerE customerE1=new CustomerE();
            customerE1.setNationalCode(username);

            CustomerS customerS=new CustomerS();
            customerS.login(customerE1);

            if (customerE.getPassword().equals(customerE1.getPassword())){

                MainMenu mm = new MainMenu();
                CustomerMenu customerMenu = new CustomerMenu(mm, true);
                customerMenu.setVisible(true);

            }else{
                StringBuilder warning = new StringBuilder();
                warning.append("national code or password incorrect.");
                JOptionPane.showMessageDialog(customerLogin, warning.toString(), "Input Error", JOptionPane.WARNING_MESSAGE);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void transferMoney(String payeeNum, String expiryDate, int cvv2) throws Exception{
        try (TransferMoneyForm transferMoneyForm = new TransferMoneyForm(new JFrame(), true)){
            CardE cardE=new CardE();
            cardE.setCardNumber(payeeNum);
            cardE.setCvv2(cvv2);
            cardE.setExpirationDate(expiryDate);

            CardE cardE1=new CardE();
            cardE1.setCardNumber(payeeNum);

            CardS cardS=new CardS();
            cardS.getCard(cardE1);

            if (cardE.getCvv2() == cardE1.getCvv2() && cardE1.getExpirationDate().equals(cardE.getExpirationDate())){
                StringBuilder success = new StringBuilder();
                success.append("Transferred successfully");
                JOptionPane.showMessageDialog(transferMoneyForm, success.toString(), "", JOptionPane.PLAIN_MESSAGE);

            }else {
                StringBuilder warn = new StringBuilder();
                warn.append("Incorrect Input");
                JOptionPane.showMessageDialog(transferMoneyForm, warn.toString(), "", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    public void showBalance(String nCode) throws Exception{
        try (CustomerLogin customerLogin = new CustomerLogin()){

            CustomerE customerE=new CustomerE();
            customerE.setNationalCode(nCode);

            CustomerS customerS = new CustomerS();
            customerS.customerId(customerE);

            AccountE accountE = new AccountE();
            accountE.setCustomerId(customerE.getId());

            AccountS accountS = new AccountS();
            accountS.getBalance(accountE);

            StringBuilder balance = new StringBuilder();
            balance.append(accountE.getBalance());
            JOptionPane.showMessageDialog(customerLogin, balance, "Account Balance", JOptionPane.PLAIN_MESSAGE);

        }
    }

    public void payDebt(String payeeNum, String type, double amount) throws Exception{
        try (PayDebtForm payDebtForm=new PayDebtForm( new JFrame(), true)){
            try (TransferMoneyForm transferMoneyForm = new TransferMoneyForm(new JFrame(), true)){

                AccountE accountE = new AccountE();

                if (type == "Loan"){
                    //accountE.setAccountNumber(payeeNum);

                }else{
                }


                StringBuilder success = new StringBuilder();
                success.append("Payed successfully");
                JOptionPane.showMessageDialog(transferMoneyForm, success.toString(), "", JOptionPane.PLAIN_MESSAGE);

            }
        }
    }

    public void createAccount(String firstName, String lastName, String fatherName, String nationalCode, String password, String cellPhone, String address, String city, String dateOfBirth) throws Exception{
        try (CreateAccountForm createAccountForm = new CreateAccountForm(new JFrame(), true)){
            CustomerE customerE = new CustomerE();
            customerE.setPassword(password);
            customerE.setNationalCode(nationalCode);
            customerE.setCity(city);
            customerE.setAddress(address);
            customerE.setCellPhone(cellPhone);
            customerE.setFatherName(fatherName);
            customerE.setLastName(lastName);
            customerE.setFirstName(firstName);
            customerE.setDateOfBirth(dateOfBirth);

            CustomerS customerS = new CustomerS();
            customerS.save(customerE);

            StringBuilder success = new StringBuilder();
            success.append("Account created successfully");
            JOptionPane.showMessageDialog(createAccountForm, success.toString(), "Successful", JOptionPane.PLAIN_MESSAGE);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}



