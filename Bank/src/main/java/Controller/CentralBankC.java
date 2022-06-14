package Controller;

import Entity.CentralBankE;
import GUI.CentralBankLogin;

public class CentralBankC {
    public void login() throws Exception{
        try(CentralBankLogin centralBankLogin=new CentralBankLogin()){
            CentralBankE centralBankE=new CentralBankE();
            centralBankE.setUsername(centralBankLogin.getUsername());
            centralBankE.setPassword(centralBankLogin.getPass());
            CentralBankE centralBankE1=new CentralBankE();

            centralBankE1.setUsername("CentralBank101");
            centralBankE1.setPassword("secure*password");
            if (centralBankE.getUsername().equals(centralBankE1.getUsername())){
                if (centralBankE.getPassword().equals(centralBankE1.getPassword())){
                    new StandardResponse(StatusResponse.SUCCESS);
                    centralBankLogin.dispose();
                }
            }
            else new StandardResponse(StatusResponse.ERROR);
        }
    }
}