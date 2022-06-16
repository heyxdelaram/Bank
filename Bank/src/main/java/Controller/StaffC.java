package Controller;

import Entity.AccountE;
import Entity.StaffE;
import GUI.CustomerLogin;
import GUI.MainMenu;
import GUI.StaffLogin;
import GUI.StaffMenu;
import Service.AccountS;
import Service.StaffS;

public class StaffC {
    public void login() throws Exception{
        try (StaffLogin staffLogin=new StaffLogin()){
            StaffE staffE=new StaffE();
            staffE.setUsername(staffLogin.getUsername());
            staffE.setPassword(staffLogin.getPass());

            StaffE staffE1=new StaffE();
            StaffS staffS=new StaffS();
            staffS.login(staffE1);
            if (staffE1.getPassword()==staffE.getPassword()){
                new StandardResponse(StatusResponse.SUCCESS);
                staffLogin.dispose();
                MainMenu mm = new MainMenu();
                StaffMenu stm = new StaffMenu(mm, true);
                stm.setVisible(true);
            }
            else new StandardResponse(StatusResponse.ERROR);
        }
    }
      public void createAccount() throws Exception {
        Random dice = new Random();
        long number = 0;
        for (long counter = 1; counter <= 10; counter++) {
            number = dice.nextLong(10);
        }


        try (CustomerLogin customerLogin = new CustomerLogin()) {
            AccountS accountS = new AccountS();
            AccountS.getInstance().save(new AccountE().setId(number));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
