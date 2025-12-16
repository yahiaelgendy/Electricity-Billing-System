package system;

import java.io.*;
import java.util.*;

public class Operator {

    public Operator() {
    }

    // (a) collect payment from customer
    public String collectPayment(Bill b,int amount) {
        try {
            if (b.getPaymentID() > 0 && b.getPayment() > 0) {
               
            if( amount >= b.getPayment())
               
                b.setPaid();
            
            //  //added
                logAction("Collected " + b.getPayment() + " LE for Bill ID " + b.getPaymentID());
                
                return "payment with " + b.getPayment() + " LE using ID "
                        +b.getPaymentID() + " succesfully\n";
            } 
            else {
                return "payment unsuccesfully \nplease make sure from details\n";
            }
        }
        catch (Exception e) {
            return "Error while collecting payment\nPlease recheck\n";
        }
    }
           //added 
    private void logAction(String action) {
        try {
            FileWriter writer = new FileWriter("Operator_Log.txt", true);
            writer.write("[Operator Action] " + action + " at " + new Date() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error logging operator action");
        }
    }

    // (b) print the bill details (updated)
    public String printBill(Bill b) {
       
            return "your bill with metercode " + b.getMeterCode()
                    + " costs " + b.getPayment() + " LE\n";
     
    }

    // (c) enable operator see bills
    public String viewRegion(String region) {
        try {
            String display = "-------you are viewing the bills of region:"
                    + region + "--------\n";
            String result = "";

            for (int i = 0; i < (int) (Math.random() * 100) + 1; i++) {
                result += "Bill of apartment " + (i + 1)
                        + " with metercode " + ((long) (Math.random() * 100_000) + 1)
                        + " paid " + ((float) (Math.random() * 1000) + 1)
                        + " LE\n";
            }

            return display + result;
        }
        catch (Exception e) {
            return "Error while viewing region bills\nPlease recheck\n";
        }
    }

    // (d) validate reading with real consumption
    public String validateReading(int enteredReading, int realReading) {
        try {
            if (enteredReading <= 0 || realReading <= 0) {
                return "Readings cannot be negative or zero.\n";
            }
            if (enteredReading == realReading) {
                return "Reading is valid and matches real consumption.\n";
            }
            else {
                return "Real reading and entered reading are not the same...Please re-check.\n";
            }
        } 
        catch (Exception e) {
            return "Error while validating reading\nPlease recheck\n";
        }
    }

    // (e) define tariff for customer
    public String defineTariffForCustomer(long meterCode, double tariff) {
        try {
            if (meterCode <= 0 || tariff <= 0) {
                return "Invalid details.\n";
            }

            Bill.currentTariff = tariff;
            return "Tariff for meter code " + meterCode
                    + " has been set to " + tariff + " per kWh.\n";
        } 
        catch (Exception e) {
            return "Error while defining tariff\nPlease recheck\n";
        }
    }

    // (f) stop meter and cancel subscription
    public String cancelSubscription(long meterCode) {
        try {
            if (meterCode <= 0) {
                return "Invalid meter code.\n";
            }

            return "Meter code : " + meterCode
                    + " has been stopped and subscription cancelled.\n";
        }
        catch (Exception e) {
            return "Error while cancelling subscription\nPlease recheck\n";
        }
    }
}