package Service;

import Entity.TransactionE;
import Repository.TransactionR;

import java.awt.*;
import java.util.List;

public class TransactionS {
    public TransactionS() { }
    private static TransactionS transactionS = new TransactionS ();
    public static TransactionS getInstance () {
        return transactionS;
    }
    public void save (TransactionE transactionE) throws Exception {
        try (TransactionR transactionR = new TransactionR ()) {
            transactionR.insert (transactionE);
            transactionR.commit ();
        }
    }
    public List<TransactionE> report() throws Exception{
        List<TransactionE> transactionES;
        try (TransactionR transactionR=new TransactionR ()){
            transactionES=transactionR.select (); }
        return transactionES; }
}