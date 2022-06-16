package Service;

import Entity.LoanE;
import Repository.LoanR;

import java.awt.*;
import java.util.List;

public class LoanS {
    public LoanS() { }
    private static LoanS loanS = new LoanS ();
    public static LoanS getInstance () {
        return loanS;
    }
    public void save (LoanE loanE) throws Exception {
        try (LoanR loanR = new LoanR ()) {
            loanR.insert (loanE);
            loanR.commit ();
        }
    }
    public void remove(long id) throws Exception{
        try (LoanR loanR=new LoanR ()){
            loanR.delete (id);
            loanR.commit ();
        } }
    public List<LoanE> report() throws Exception{
        List<LoanE> loanES;
        try (LoanR loanR=new LoanR ()){
            loanES=loanR.select (); }
        return loanES; }
}