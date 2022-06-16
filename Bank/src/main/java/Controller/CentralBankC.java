package Controller;

import Entity.CentralBankE;
import GUI.CentralBankLogin;
import GUI.MainMenu;
import Service.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CentralBankC {
    public void login(String username, String pass) throws Exception{
        try(CentralBankLogin centralBankLogin = new CentralBankLogin(new MainMenu(), true)){
            CentralBankE centralBankE=new CentralBankE();

            centralBankE.setUsername(username);
            centralBankE.setPassword(pass);
            CentralBankE centralBankE1=new CentralBankE();

            centralBankE1.setUsername("CentralBank101");
            centralBankE1.setPassword("secure*password");
            if (centralBankE1.getUsername().equals(centralBankE.getUsername()) && centralBankE1.getPassword().equals(centralBankE.getPassword())){
                StringBuilder success = new StringBuilder();
                success.append("\tLogin successful.");
                JOptionPane.showMessageDialog(centralBankLogin, success.toString(), "", JOptionPane.PLAIN_MESSAGE);
                CentralBankC centralBankC = new CentralBankC();
                //JOptionPane.showMessageDialog(centralBankLogin, centralBankC.showAllData(), "", JOptionPane.PLAIN_MESSAGE);
            }
            else{
                StringBuilder warning = new StringBuilder();
                warning.append("username or password incorrect.");
                JOptionPane.showMessageDialog(centralBankLogin, warning.toString(), "Input Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public List showAllData(List list) throws Exception{
        //List<List> list=new ArrayList<>();
        AccountS accountS=new AccountS();
        list.add(String.valueOf(accountS.report()));
        CardS cardS=new CardS();
        list.add(String.valueOf(cardS.report()));
        CheckS checkS=new CheckS();
        list.add(String.valueOf(cardS.report()));
        CustomerS customerS=new CustomerS();
        list.add(String.valueOf(customerS.report()));
        LoanS loanS=new LoanS();
        list.add(String.valueOf(loanS.report()));
        StaffS staffS=new StaffS();
        list.add(String.valueOf(staffS.report()));
        TransactionS transactionS=new TransactionS();
        list.add(String.valueOf(transactionS.report()));
        return list;
    }
}
