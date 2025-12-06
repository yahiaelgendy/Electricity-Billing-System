package system;

import java.util.ArrayList;

public class Admin extends User {

    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    // (A) View all bills of specific regions
    public void viewBillsByRegion(String region, ArrayList<Bill> allBills) {
        System.out.println("\n--- Admin: Bills for " + region + " ---");
        boolean found = false;
        for (Bill bill : allBills) {
            if (bill.getRegion().equalsIgnoreCase(region)) {
                System.out.println(bill);
                found = true;
            }
        }
        if (!found) System.out.println("No bills found.");
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
        if (removed) System.out.println("Admin: User " + userId + " deleted.");
        else System.out.println("Admin: User not found.");
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