package system;

public class Operator {

    public Operator() {
    }

    // (a) collect payment from customer
    public String collectPayment(long paymentID, double payment) {
        if (paymentID > 0 && payment > 0) {
            return "payment with " + payment + " LE" + " using ID " +  +paymentID + " succesfully\n";
        } else {
            return "payment unsuccesfully \nplease make sure from details\n";
        }
    }

    // (b) print the bill details (updated (use bill class))
    public String printBill(long meterCode , double payment) {
        return "your bill with metercode " + meterCode + " costs " + payment + " LE\n";
    }

    // (c) enable operator see bills 
    public String viewRegion(String region) {

            String display = "-------you are viewing the bills of region:" + region + "--------\n";
            String result = "";

            for (int i = 0; i < (int) (Math.random() * 100) + 1; i++) {
                result += "Bill of apartment " + (i + 1)
                        + " with metercode " + (long) (Math.random() * 100_000) + 1
                        + " paid " + (float) (Math.random() * 1000) + 1
                        + " LE\n";
            }

            return display + result;

    }

    // (d) validate reading with real consumption
    public String validateReading(int enteredReading, int realReading) {
        if (enteredReading <= 0 || realReading <= 0) {
            return "Readings cannot be negative or zero.\n";
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

        Bill.currentTariff = tariff;
        return "Tariff for meter code " + meterCode
                + " has been set to " + tariff + " per kWh.\n";
    }

    // (f) stop meter and cancel subscription
    public String cancelSubscription(long meterCode) {
        if (meterCode <= 0) {
            return "Invalid meter code.\n";
        }

        return "Meter code : " + meterCode
            + " has been stopped and subscription cancelled.\n";
    }
}
