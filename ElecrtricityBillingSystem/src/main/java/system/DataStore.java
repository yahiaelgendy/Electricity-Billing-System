package system;

import java.util.*;

public class DataStore {

    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Bill> bills = new ArrayList<>();

    static {
        users.add(new Admin(1,"Admin","admin@mail.com","123"));
        users.add(new Operator(2, "Operator" , "operator@mail.com" , "456"));
        users.add(new NewCustomer(3 , "NewCustomer" , "newcustomer@mail.com" ,"777"));
        users.add(new OldCustomer(4 , "OldCustomer" , "oldcustomer@mail.com" ,"666" , 2222));
        
        bills.add(new Bill(1019172 , false , 627.5 , 464242 , "Nasr-city" ));
        bills.add(new Bill(1019173 , false , 877.33 , 464237 , "Madinty" ));
    }
}