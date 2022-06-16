package Controller;

import Entity.AccountE;
import Entity.CentralBankE;
import GUI.CentralBankLogin;
import GUI.MainMenu;
import Service.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

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
            }
            else{
                StringBuilder warning = new StringBuilder();
                warning.append("username or password incorrect.");
                JOptionPane.showMessageDialog(centralBankLogin, warning.toString(), "Input Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    public List showAllData() throws Exception{
       List<List> list=new ArrayList<>();
        AccountS accountS=new AccountS();
        list.add(accountS.report());
        CardS cardS=new CardS();
        list.add(cardS.report());
        CheckS checkS=new CheckS();
        list.add(cardS.report());
        CustomerS customerS=new CustomerS();
        list.add(customerS.report());
        LoanS loanS=new LoanS();
        list.add(loanS.report());
        StaffS staffS=new StaffS();
        list.add(staffS.report());
        TransactionS transactionS=new TransactionS();
        list.add(transactionS.report());
    return list;
    }
}
