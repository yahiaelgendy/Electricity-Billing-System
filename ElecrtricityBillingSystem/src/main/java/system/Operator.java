package system;

import java.util.*;

public class Operator extends User {

    private double payment;
    private long paymentID;
    private double currentTariff = 1.0;
    private final String[] regions = {"Masr-ELGedida", "Nasr-City", "Ain-Shams", "Helmya"};

    public Operator() {
    }

    // (a) collect payment from customer
    public String collectPayment(long paymentID, double payment) {
        if (paymentID > 0) {
            return "payment with " + payment + "using " + paymentID + "succesfully";
        } else {
            return "payment unsuccesfully \n please make sure from details";
        }
    }

    // (b) print the bill details (updated (use bill class))
    public String printBill(Bill bill) {
        return "your bill with metercode " + bill.getMeterCode()+ "costs" + bill.getAmount();
    }

    // (c) enable operator see bills (updated)******* 
    public String viewRegion(String region, ArrayList<Bill> bills) {
        
        String result ="----"+region+"----\n";
        
        /*check if region valid */
        boolean valid = false;

        for (String r : regions)
            if (r.equalsIgnoreCase(region)) {
                valid = true;
                break;}
        
        if(!valid) return "invalid region";
        
        
       for(Bill b : bills){
         if (b.getRegion().equalsIgnoreCase(region)) { 
            result += b.toString() + "\n";
        }
       }
       
       return result;
    }
        // (d) validate reading with real consumption
    public String validateReading(int enteredReading, int realReading) {
        if (enteredReading < 0 || realReading < 0) {
            return "Readings cannot be negative.\n";
        }
        if (enteredReading == realReading) {
            return "Reading is valid and matches real consumption.\n";
        } else {
            return "Real reading and entered reading are not the same...Please re-check.\n";
        }
    }

    // (e) define tariff for customer
    public String defineTariffForCustomer(long meterCode, double tariff) {
        if (meterCode <= 0 || tariff <= 0) {
            return "Invalid details.\n";
        }

        this.currentTariff = tariff;
        return "Tariff for meter code " + meterCode
                + " has been set to " + tariff + " per kWh.\n";
    }

    // (f) stop meter and cancel subscription
    public String cancelSubscription(long meterCode) {
        if (meterCode <= 0) {
            return "Invalid meter code.";
        }

        return "Meter code : " + meterCode
                + " has been stopped and subscription cancelled.\n";
    }
}