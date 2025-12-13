package system;

import java.util.*;

public class Admin {
   

    public Admin() {
    }

    // (A) View all bills of specific regions
    public String viewBillsByRegion(String region) {
  
            int numberOfUnits = (int) (Math.random() * 100) + 1;
            String result = "";
            String display = "-------you are viewing the bills of region:" + region + "--------\n";

            for (int j = 0; j < 4; j++){

                result += "\n --- Month " + (j + 1) + " ---\n";

                for (int i = 0; i < numberOfUnits; i++) {
                    result += "Bill of apartment " + (i + 1)
                            + " with metercode " + (long) (Math.random() * 100_000) + 1
                            + " paid " + (Math.random() * 1000) + 1
                            + " LE\n";
                }
            }
            return display + result;

    }

    // (B) View total collected (Only Paid Bills)
    public String viewTotalCollected(ArrayList<Bill> allBills) {
        double total = 0;
        
        for (Bill bill : allBills) {
            if (bill.isPaid()) {
                total += bill.getPayment();
            }
        }
        return "--- Admin: Total Collected Revenue ---\n" + "Total collected : " + total;
    }

    // (C) Consumption statistics for specific region
    public String reportConsumptionStats(String region, ArrayList<Bill> allBills) {
       double sum = 0;
       int size = 0;
       
         for (Bill bill : allBills) {
            if (bill.isPaid()) {
                sum += bill.getPayment();
                size++;
            }
        }   
         
       return  "Region : "  + region + "\nNumber of units is : " + size + 
            "\nAverage of total collected = " + sum / size + "\n";
    }

    // (D) Manage Users (Add / Update / Delete)
    // 1. Add
    public String addUser(ArrayList<User> users, User newUser) {
        users.add(newUser);
        return "Admin: User " + newUser.getName() + " added.\n";
    }

    // 2. Delete
    public String deleteUser(ArrayList<User> users, int userId) {
        boolean removed = users.removeIf(u -> u.getId() == userId);
        if (removed) {
            return "Admin: User " + userId + " deleted.";
        } else {
            return "Admin: User not found.";
        }
    }

    // 3. Update (Email for example)
    public String updateUserEmail(ArrayList<User> users, int userId, String newEmail) {
        for (User u : users) {
            if (u.getId() == userId) {
                u.setEmail(newEmail);
                return "Admin: Email updated for " + u.getName(); 
            }
        }
        return "Admin: User not found to update.";
    }
}
