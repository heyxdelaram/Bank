package Service;

import Entity.CustomerE;
import Repository.CustomersR;

import java.util.List;

public class CustomerS {
    public CustomerS(){}
    private static CustomerS customerS=new CustomerS();
    public static CustomerS getInstance(){
        return customerS;
    }
    public void login(CustomerE customerE) throws Exception{
        try (CustomersR customersR=new CustomersR()){
            customersR.selectPassword(customerE);
        }
    }
    public void save(CustomerE customerE) throws Exception{
        try (CustomersR customersR=new CustomersR()){
            customersR.insert (customerE);
            customersR.commit ();
        }
    }
    public List<CustomerE> report() throws Exception{
        List<CustomerE> customerES;
        try (CustomersR customersR=new CustomersR ()){
            customerES=customersR.select (); }
        return customerES; }
}
