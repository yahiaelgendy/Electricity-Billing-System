package system;

import java.io.*;

public class Bill {

    protected long meterCode;
        // updated 
    protected boolean isPaid;
    protected double payment;
    protected long paymentID;
    protected static double currentTariff = 1.0; 
    public Bill(long meterCode, boolean isPaid, double payment, long paymentID) {

        //validate inputs 
        if(meterCode <=0 ||payment<0 || paymentID <=0 ){
            throw new IllegalArgumentException("\"Invalid inputs code\"");
        }
        
        this.meterCode = meterCode;
        this.isPaid = isPaid;
        this.payment = payment;
        this.paymentID = paymentID;
    }
    
      //added
    public void saveBillToFile() {
        try {
            FileWriter writer = new FileWriter("Bills.txt", true);
            writer.write("Bill ID: " + paymentID + " | Meter: " + meterCode + " | Amount: " + payment + " | Status: " + (isPaid ? "Paid" : "Unpaid") + "\n");
            writer.close();
            System.out.println("Bill saved to Bills.txt ");
        } catch (IOException e) {
            System.out.println("Error saving bill");
        }
    }
    // add new mathod**
    public void setPaid(){
        isPaid = true;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public long getMeterCode() {
        return meterCode;
    }

    // updated
    public double getPayment() {
        return payment;
    }

    public long getPaymentID() {
        return paymentID;
    }

    // updated
    @Override
    public String toString() {

        return "Bill details :\n - Metercode: " + meterCode +  "\n - Payment: " +
            payment + "\n - payment ID: " + paymentID;
    }

}