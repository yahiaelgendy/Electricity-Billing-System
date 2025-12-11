package system;

import java.util.ArrayList;

public class Admin {

    public Admin() {
    }

    // (A) View all bills of specific regions
    public String viewBillsByRegion(String region) {
        if (region.equalsIgnoreCase(Bill.regions[0])
                || region.equalsIgnoreCase(Bill.regions[1])
                || region.equalsIgnoreCase(Bill.regions[2])
                || region.equalsIgnoreCase(Bill.regions[3])) {

            String result = "";
            String display = "-------you are viewing the bills of region:" + region + "--------\n";

            for (int j = 0; j < 2; j++) {

                result += "\n --- Month " + (j + 1) + " ---\n";

                for (int i = 0; i < (int) (Math.random() * 20) + 1; i++) {
                    result += "Bill of apartment " + (i + 1)
                            + " with metercode " + (long) (Math.random() * 100_000) + 1
                            + " paid " + (Math.random() * 1000) + 1
                            + " LE\n";
                }
            }
            return display + result;
        }
        return "Sorry this region is uncovered by you\n";
    }

    // (B) View total collected (Only Paid Bills)
    public void viewTotalCollected(ArrayList<Bill> allBills) {
        double total = 0;
        for (Bill bill : allBills) {
            if (bill.isPaid()) {
                total += bill.getAmount();
            }
        }
        System.out.println("\n--- Admin: Total Collected Revenue ---");
        System.out.println("Total: " + total + " EGP");
    }

    // (C) Consumption statistics for specific region
    public void reportConsumptionStats(String region, ArrayList<Bill> allBills) {
        double totalUnits = 0;
        int count = 0;

        for (Bill bill : allBills) {
            if (bill.getRegion().equalsIgnoreCase(region)) {
                totalUnits += bill.getUnits();
                count++;
            }
        }

        System.out.println("\n--- Admin: Stats for " + region + " ---");
        System.out.println("Total Bills: " + count);
        System.out.println("Total Consumption: " + totalUnits + " kW/h");
        if (count > 0) {
            System.out.println("Average Consumption: " + (totalUnits / count) + " kW/h");
        }
    }

    // (D) Manage Users (Add / Update / Delete)
    // 1. Add
    public void addUser(ArrayList<User> users, User newUser) {
        users.add(newUser);
        System.out.println("Admin: User " + newUser.getName() + " added.");
    }

    // 2. Delete
    public void deleteUser(ArrayList<User> users, int userId) {
        boolean removed = users.removeIf(u -> u.getId() == userId);
        if (removed) {
            System.out.println("Admin: User " + userId + " deleted.");
        } else {
            System.out.println("Admin: User not found.");
        }
    }

    // 3. Update (Email for example)
    public void updateUserEmail(ArrayList<User> users, int userId, String newEmail) {
        for (User u : users) {
            if (u.getId() == userId) {
                u.setEmail(newEmail);
                System.out.println("Admin: Email updated for " + u.getName());
                return;
            }
        }
        System.out.println("Admin: User not found to update.");
    }
}
