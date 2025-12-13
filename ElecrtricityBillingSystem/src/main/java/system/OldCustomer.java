
package system;

public class OldCustomer extends User {

    protected long meterCode;
    protected int monthlyreading;
    
    public OldCustomer(int id, String name, String email, String password, long meterCode, int monthlyReading) {
        super(id, name, email, password);
        this.meterCode = meterCode;
    }
    
    
    // (a) enable customer pay with metercode
    public String payBill(long meterCode, double payment) {
        return "Customer " + name + " paid: " + payment + " using meter code: " + meterCode;
    }
    

    // (b) enable customer set monthly reading
    public void setMonthlyReading(int monthlyReading) {
        this.monthlyreading = monthlyReading;
    }
     

    // (c) enable customer complain about bill 
    public String complaintAboutBill(long meterCode, String message) {
        return "your complaint about the bill with meter code: " + meterCode + " is: " + message + "\n we will review your complaint, thank you for your feedback";
    }

    // (d) enable customer check unpaid months if more than 2 
    public String checkUnpaidMonths(int unpaidMonths) {
        if (unpaidMonths >= 3) {
            return "An email will be sent to: " + email + " due to delay in paying";
        } else {
            return "No urgent bills should be paid";
        }
    }
}
