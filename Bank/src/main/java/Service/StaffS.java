package Service;

import Entity.StaffE;
import Repository.StaffR;

import java.util.List;

public class StaffS {
    public StaffS(){}

    private static StaffS staffS = new StaffS();
    public static StaffS getInstance(){
        return staffS;
    }

    public void login(StaffE staffE) throws Exception{
        try (StaffR staffR=new StaffR()){
            staffR.selectPassword(staffE);
            staffR.selectUsername(staffE);
        }
    }

    public List<StaffE> report() throws Exception{
        List<StaffE> staffES = null;
        try (StaffR staffR = new StaffR()){
            staffES = staffR.select();
        }
        return staffES;
    }
}