package Controller;

import Entity.CustomerE;
import GUI.CustomerLogin;
import GUI.CustomerMenu;
import GUI.MainMenu;
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
                new StandardResponse(StatusResponse.SUCCESS);
                customerLogin.dispose();
                MainMenu mm = new MainMenu();
                CustomerMenu customerMenu = new CustomerMenu(mm, true);
                customerMenu.setVisible(true);
            }else
                new StandardResponse(StatusResponse.ERROR);
        }
    }
}

