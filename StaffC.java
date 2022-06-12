package Controller;

import Entity.AccountE;
import Entity.StaffE;
import GUI.CustomerLogin;
import GUI.StaffLogin;
import Service.AccountS;
import Service.StaffS;

public class StaffC {
    public void login() throws Exception{
        try (StaffLogin staffLogin=new StaffLogin()){
            StaffE staffE=new StaffE();
            staffE.setUsername(staffLogin.getUsernameText().getText());
            staffE.setPassword(staffLogin.getPassText().getText());
            StaffE staffE1=new StaffE();
            StaffS staffS=new StaffS();
            staffS.login(staffE1);
            if (staffE1.getPassword()==staffE.getPassword()){
                new StandardResponse(StatusResponse.SUCCESS);
            }
            else new StandardResponse(StatusResponse.ERROR);
        }
    }
    public void createAccount() throws Exception{
        try (CustomerLogin customerLogin=new CustomerLogin()){
            AccountS.getInstance().save(new AccountE().setId(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
