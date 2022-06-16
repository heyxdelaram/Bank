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
    public void login() throws Exception{
        //MainMenu mainMenu = new MainMenu();
        try (CustomerLogin customerLogin = new CustomerLogin()){
            CustomerE customerE=new CustomerE();
            customerE.setNationalCode(customerLogin.getnCode());
            customerE.setPassword(customerLogin.getPass());

            CustomerE customerE1=new CustomerE();
            CustomerS customerS=new CustomerS();
            customerS.login(customerE1);
            if (customerE.getPassword() == customerE1.getPassword()){
                System.out.println(new StandardResponse(StatusResponse.SUCCESS));
                customerLogin.dispose();
                MainMenu mm = new MainMenu();
                CustomerMenu customerMenu = new CustomerMenu(mm, true);
                customerMenu.setVisible(true);
            }else
                new StandardResponse(StatusResponse.ERROR);
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

