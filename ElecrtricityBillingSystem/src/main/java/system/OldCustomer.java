package system;

import java.io.*;
import java.util.*;
public class OldCustomer extends User {

    protected long meterCode;
    protected int monthlyReading;
    
  
    public OldCustomer(int id, String name, String email, String password, long meterCode) {
        super(id, name, email, password);
        if (meterCode <= 0) {
            throw new IllegalArgumentException("Invalid monthlyreading code\nPlease recheck\n");
        }
        this.meterCode = meterCode;
    }
    
    
    // (a) enable customer pay with metercode//add Bill class
    public String payBill(Bill b, double amount) {
     
            if(this.meterCode != b.getMeterCode()){
                return "not the same meterCode\n please recheck your meterCode";
            }
            
            if( amount >= b.getPayment()){
                b.setPaid();            
                logPaymentToFile(b.getPayment());
                return "Customer " + name + " paid: " + b.getPayment() + " using meter code: " +b.getMeterCode();
            }else 
                return "your amount is not enough";
        }
    
    
    
      //added
    private void logPaymentToFile(double amount) {
        try {
            FileWriter writer = new FileWriter("Payments_History.txt", true);
            writer.write("Customer: " + name + " | Paid: " + amount + " LE | Date: " + new Date() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error logging payment");
        }
    }

    
    

    // (b) enable customer set monthly reading
    public void setMonthlyReading(int monthlyReading) {
        
            try {
            if (monthlyReading < 0) {
                throw new IllegalArgumentException("Invalid monthly reading\nPlease recheck\n");
            }
            this.monthlyReading = monthlyReading;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
        
    
    
    // (c) enable customer complain about bill 
    public String complaintAboutBill(long meterCode, String message) {
        try {
            if (message == null) {
                throw new IllegalArgumentException("Invalid complaint message");
            }
            return "your complaint about the bill with meter code: " + meterCode + " is: " + message
                    + "\n we will review your complaint, thank you for your feedback";
        } 
        catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    // (d) enable customer check unpaid months if more than 2 
    public String checkUnpaidMonths(int unpaidMonths) {
        try {
            if (unpaidMonths < 0) {
                throw new IllegalArgumentException("Invalid unpaid months\nPlease recheck");
            }
            if (unpaidMonths >= 3) {
                return "An email will be sent to: " + email + " due to delay in paying";
            } 
            else{
                return "No urgent bills should be paid";
            }
        } 
        catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
