package Service;

import Entity.StaffE;
import Repository.StaffR;

public class StaffS {
    public StaffS(){}
    private static StaffS staffS=new StaffS();
    public static StaffS getInstance(){
        return staffS;
    }
    public StaffE login(StaffE staffE) throws Exception{
        try (StaffR staffR=new StaffR()){
            staffR.selectPassword(staffE);
            staffE.setPassword(staffE.getPassword());
            return staffE;
        }
    }
}
