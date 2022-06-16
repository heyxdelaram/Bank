package Controller;

import Entity.CentralBankE;
import GUI.CentralBankLogin;
import GUI.MainMenu;

import javax.swing.*;
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
}
