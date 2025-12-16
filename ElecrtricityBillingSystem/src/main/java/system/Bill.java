package system;

public class Bill {

    protected long meterCode;
        // updated 
    protected static boolean isPaid;
    protected double payment;
    protected long paymentID;
    protected static double currentTariff = 1.0; 
    protected String region;
    
    public Bill(long meterCode, boolean isPaid, double payment, long paymentID , String region) {

        this.meterCode = meterCode;
        this.isPaid = isPaid;
        this.payment = payment;
        this.paymentID = paymentID;
        this.region = region;
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
    
    public void setRegion(String region){
        this.region = region;
    }
    
    public String getRegion(){
        return region;
    }

    // updated
    @Override
    public String toString() {

        return "Bill details :\n - Metercode: " + meterCode +  "\n - Payment: " +
            payment + "\n - payment ID: " + paymentID + "\n - Region : " + region ;
    }

}
