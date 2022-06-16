package Controller;

import Entity.AccountE;
import Entity.CardE;
import Entity.CustomerE;
import GUI.*;
import Service.CardS;
import Service.CustomerS;

import java.awt.*;
import java.util.Objects;

public class CustomerC {
    public void login(String username, String pass) throws Exception{
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
   
    public void transferMoney() throws Exception{
        try (TransferMoneyForm transferMoneyForm=new TransferMoneyForm()){
            CardE cardE=new CardE();
            cardE.setCardNumber(transferMoneyForm.getPayeeNumText().getText());
            cardE.setExpirationDate(transferMoneyForm.getExpiryDateText().getText());
            cardE.setCvv2(Integer.parseInt(transferMoneyForm.getCvv2Text().getText()));

            CardE cardE1=new CardE();
            CardS cardS=new CardS();
            cardS.getCard(cardE1);
            if (cardE.getCardNumber()==cardE1.getCardNumber()&&cardE.getCvv2()==cardE1.getCvv2()&&cardE.getExpirationDate()==cardE1.getExpirationDate()){
                new StandardResponse(StatusResponse.SUCCESS);
            }
        }
    }
    public double showBalance() throws Exception{
        try (CustomerLogin customerLogin=new CustomerLogin()){
            CustomerE customerE=new CustomerE();
            customerE.setNationalCode(customerLogin.getnCode());
            AccountE accountE=new AccountE();
            accountE.setId(customerE.getId());
            double balance=accountE.getBalance();
        return balance;
        }
    }

    public void payDebt() throws Exception{
        try (PayDebtForm payDebtForm=new PayDebtForm()){
            AccountE accountE=new AccountE();
            accountE.setAccountNumber(payDebtForm.getPayeeNumText().getText());
        }
    }
}

