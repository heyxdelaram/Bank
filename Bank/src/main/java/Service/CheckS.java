package Service;

import Entity.CheckE;
import Repository.CheckR;

import java.util.List;

public class CheckS {
    private CheckS(){}
    private static CheckS checkS=new CheckS();
    public static CheckS getInstance(){
        return checkS;
    }
    public void save(CheckE checkE) throws Exception{
        try (CheckR checkR=new CheckR()){
            checkR.insert(checkE);
            checkR.commit();
        }
    }
    public List<CheckE> report() throws Exception{
        List<CheckE> checkES;
        try (CheckR checkR=new CheckR()){
            checkES=checkR.select();
        }
        return checkES;
    }
}
