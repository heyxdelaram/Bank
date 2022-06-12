package Controller;

import Entity.CustomerE;
import GUI.CustomerLogin;
import Service.CustomerS;

public class CustomerC {
    public void login() throws Exception{
        try (CustomerLogin customerLogin=new CustomerLogin()){
            CustomerE customerE=new CustomerE();
            customerE.setNationalCode(customerLogin.getnCodeText().getText());
            customerE.setPassword(customerLogin.getPassText().getText());
            CustomerE customerE1=new CustomerE();
            CustomerS customerS=new CustomerS();
            customerS.login(customerE1);
            if (customerE.getPassword()==customerE1.getPassword()){
                new StandardResponse(StatusResponse.SUCCESS);
            }else new StandardResponse(StatusResponse.ERROR);
        }
    }
}
