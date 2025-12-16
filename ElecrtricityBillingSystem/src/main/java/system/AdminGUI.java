package system;

import javax.swing.*;
import java.util.ArrayList;

public class AdminGUI {

    public AdminGUI(Admin admin) {

        JFrame f = new JFrame("Admin Panel");
        f.setSize(750, 550);
        f.setLayout(null);

        JTextArea area = new JTextArea();
        area.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(20, 20, 700, 220);
        f.add(scroll);

        // ================= Inputs =================
        JLabel r = new JLabel("Region");
        r.setBounds(20, 260, 80, 25);
        f.add(r);

        JTextField region = new JTextField();
        region.setBounds(100, 260, 120, 25);
        f.add(region);

        JLabel uid = new JLabel("User ID");
        uid.setBounds(240, 260, 80, 25);
        f.add(uid);

        JTextField userID = new JTextField();
        userID.setBounds(320, 260, 120, 25);
        f.add(userID);

        JLabel mail = new JLabel("New Email");
        mail.setBounds(460, 260, 80, 25);
        f.add(mail);

        JTextField newEmail = new JTextField();
        newEmail.setBounds(550, 260, 160, 25);
        f.add(newEmail);

        // ================= Buttons =================
        JButton viewBills = new JButton("View Bills");
        viewBills.setBounds(20, 310, 150, 30);
        f.add(viewBills);

        JButton total = new JButton("Total Collected");
        total.setBounds(190, 310, 170, 30);
        f.add(total);

        JButton stats = new JButton("Consumption Stats");
        stats.setBounds(380, 310, 170, 30);
        f.add(stats);

        JButton update = new JButton("Update Email");
        update.setBounds(570, 310, 150, 30);
        f.add(update);

        JButton delete = new JButton("Delete User");
        delete.setBounds(190, 360, 170, 30);
        f.add(delete);

        // ================= Actions =================
        viewBills.addActionListener(e ->
                area.setText(admin.viewBillsByRegion(region.getText()))
        );

        total.addActionListener(e ->
                area.setText(admin.viewTotalCollected(DataStore.bills))
        );

        stats.addActionListener(e ->
                area.setText(admin.reportConsumptionStats(region.getText(), DataStore.bills))
        );

        update.addActionListener(e -> {
            try {
                int id = Integer.parseInt(userID.getText());
                area.setText(admin.updateUserEmail(DataStore.users, id, newEmail.getText()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Invalid input");
            }
        });

        delete.addActionListener(e -> {
            try {
                int id = Integer.parseInt(userID.getText());
                area.setText(admin.deleteUser(DataStore.users, id));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Invalid input");
            }
        });

        f.setVisible(true);
    }
}
