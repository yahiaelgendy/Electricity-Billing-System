package system;

import javax.swing.*;

public class NewCustomerGUI {

    public NewCustomerGUI(NewCustomer c) {

        JFrame f = new JFrame("New Customer Panel");
        f.setSize(700, 520);
        f.setLayout(null);

        JTextArea area = new JTextArea();
        area.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(20, 20, 640, 220);
        f.add(scroll);

        // ================= Inputs =================
        JLabel l1 = new JLabel("ID");
        l1.setBounds(20, 260, 80, 25);
        f.add(l1);

        JTextField id = new JTextField();
        id.setBounds(100, 260, 120, 25);
        f.add(id);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(240, 260, 80, 25);
        f.add(l2);

        JTextField name = new JTextField();
        name.setBounds(320, 260, 120, 25);
        f.add(name);

        JLabel l3 = new JLabel("Email");
        l3.setBounds(460, 260, 80, 25);
        f.add(l3);

        JTextField email = new JTextField();
        email.setBounds(540, 260, 120, 25);
        f.add(email);

        JLabel l4 = new JLabel("Password");
        l4.setBounds(20, 300, 80, 25);
        f.add(l4);

        JTextField password = new JTextField();
        password.setBounds(100, 300, 120, 25);
        f.add(password);

        JLabel l5 = new JLabel("Contract Path");
        l5.setBounds(240, 300, 100, 25);
        f.add(l5);

        JTextField contract = new JTextField();
        contract.setBounds(350, 300, 200, 25);
        f.add(contract);

        // ================= Buttons =================
        JButton setInfo = new JButton("Set Information");
        setInfo.setBounds(20, 350, 180, 30);
        f.add(setInfo);

        JButton attach = new JButton("Attach Contract");
        attach.setBounds(240, 350, 180, 30);
        f.add(attach);

        JButton meter = new JButton("Check Meter Code");
        meter.setBounds(460, 350, 200, 30);
        f.add(meter);

        JButton show = new JButton("Show Info");
        show.setBounds(240, 400, 180, 30);
        f.add(show);

        // ================= Actions =================
        setInfo.addActionListener(e -> {
            try {
                c.setAllInformation(
                        Integer.parseInt(id.getText()),
                        name.getText(),
                        email.getText(),
                        password.getText()
                );
                area.setText("Information saved successfully\n");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Invalid input");
            }
        });

        attach.addActionListener(e -> {
            c.attachContract(contract.getText());
            area.setText("Contract attached successfully\n");
        });

        meter.addActionListener(e ->
                area.setText(c.checkMeterCode())
        );

        show.addActionListener(e ->
                area.setText(c.getAllInformation())
        );

        f.setVisible(true);
    }
}
