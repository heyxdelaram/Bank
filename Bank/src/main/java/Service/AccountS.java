package Service;

import Entity.AccountE;
import Repository.AccountR;

import java.awt.*;
import java.util.List;

public class AccountS {
    public AccountS() {}
    private static AccountS accountS=new AccountS();
    public static AccountS getInstance(){
        return accountS;
    }
    public void save(AccountE accountE) throws Exception{
        try(AccountR accountR=new AccountR()) {
            accountR.insert(accountE);
            accountR.commit();
        }
    }
    public void remove(long id) throws Exception{
        try (AccountR accountR=new AccountR()){
            accountR.delete(id);
            accountR.commit();
        }
    }
    public List<AccountE> report() throws Exception {
        List<AccountE> accountES;
        try (AccountR accountR = new AccountR()) {
            accountES = accountR.select();
        }
        return accountES;
    }

    public void getBalance(AccountE accountE) throws Exception{
        try (AccountR accountR = new AccountR()){
            accountR.selectBalance(accountE);
        }
    }

    public void pay(AccountE accountE) throws Exception{
        try (AccountR accountR = new AccountR()){
            accountR.selectBalance(accountE);
        }
    }
}