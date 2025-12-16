package system;

import javax.swing.*;

public class OperatorGUI {

    public OperatorGUI(Operator op) {

        JFrame f = new JFrame("Operator Panel");
        f.setSize(720, 580);
        f.setLayout(null);

        JTextArea area = new JTextArea();
        area.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 13));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(20, 20, 670, 200);
        f.add(scroll);

        // ================= Collect Payment =================
        JLabel l1 = new JLabel("Payment ID");
        l1.setBounds(20, 240, 100, 25);
        f.add(l1);

        JTextField paymentID = new JTextField();
        paymentID.setBounds(120, 240, 100, 25);
        f.add(paymentID);

        JLabel l2 = new JLabel("Payment");
        l2.setBounds(240, 240, 100, 25);
        f.add(l2);

        JTextField payment = new JTextField();
        payment.setBounds(330, 240, 100, 25);
        f.add(payment);

        JButton collect = new JButton("Collect Payment");
        collect.setBounds(470, 240, 200, 25);
        f.add(collect);

        // ================= Print Bill =================
        JLabel l3 = new JLabel("Meter Code");
        l3.setBounds(20, 280, 100, 25);
        f.add(l3);

        JTextField meterCode = new JTextField();
        meterCode.setBounds(120, 280, 100, 25);
        f.add(meterCode);

        JLabel l4 = new JLabel("Amount");
        l4.setBounds(240, 280, 100, 25);
        f.add(l4);

        JTextField amount = new JTextField();
        amount.setBounds(330, 280, 100, 25);
        f.add(amount);

        JButton print = new JButton("Print Bill");
        print.setBounds(470, 280, 200, 25);
        f.add(print);

        // ================= View Region =================
        JLabel l5 = new JLabel("Region");
        l5.setBounds(20, 320, 100, 25);
        f.add(l5);

        JTextField region = new JTextField();
        region.setBounds(120, 320, 100, 25);
        f.add(region);

        JButton view = new JButton("View Region");
        view.setBounds(470, 320, 200, 25);
        f.add(view);

        // ================= Validate Reading =================
        JLabel er = new JLabel("Entered Reading");
        er.setBounds(20, 360, 120, 25);
        f.add(er);

        JTextField entered = new JTextField();
        entered.setBounds(150, 360, 100, 25);
        f.add(entered);

        JLabel rr = new JLabel("Real Reading");
        rr.setBounds(270, 360, 120, 25);
        f.add(rr);

        JTextField real = new JTextField();
        real.setBounds(400, 360, 100, 25);
        f.add(real);

        JButton validate = new JButton("Validate Reading");
        validate.setBounds(530, 360, 160, 25);
        f.add(validate);

        // ================= Define Tariff =================
        JLabel mc = new JLabel("Meter Code");
        mc.setBounds(20, 400, 120, 25);
        f.add(mc);

        JTextField meter = new JTextField();
        meter.setBounds(150, 400, 100, 25);
        f.add(meter);

        JLabel tr = new JLabel("Tariff");
        tr.setBounds(270, 400, 120, 25);
        f.add(tr);

        JTextField tariff = new JTextField();
        tariff.setBounds(400, 400, 100, 25);
        f.add(tariff);

        JButton setTariff = new JButton("Set Tariff");
        setTariff.setBounds(530, 400, 160, 25);
        f.add(setTariff);

        // ================= Cancel Subscription =================
        JLabel cm = new JLabel("Meter Code");
        cm.setBounds(20, 440, 120, 25);
        f.add(cm);

        JTextField cancelMeter = new JTextField();
        cancelMeter.setBounds(150, 440, 100, 25);
        f.add(cancelMeter);

        JButton cancel = new JButton("Cancel Subscription");
        cancel.setBounds(530, 440, 160, 25);
        f.add(cancel);

        // ================= Actions =================
        collect.addActionListener(e -> {
            try {
                if (paymentID.getText().trim().isEmpty() || payment.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(f, "Please enter payment ID and amount");
                    return;
                }
                long pid = Long.parseLong(paymentID.getText());
                double pay = Double.parseDouble(payment.getText());
                area.setText(op.collectPayment(pid, pay));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Invalid payment input");
            }
        });

        print.addActionListener(e -> {
            try {
                if (meterCode.getText().trim().isEmpty() || amount.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(f, "Please enter meter code and amount");
                    return;
                }
                long meterC = Long.parseLong(meterCode.getText());
                double pay = Double.parseDouble(amount.getText());
                area.setText(op.printBill(meterC, pay));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Invalid bill input");
            }
        });

        view.addActionListener(e -> {
            String reg = region.getText().trim();
            if (reg.isEmpty()) {
                JOptionPane.showMessageDialog(f, "Please enter region name");
                return;
            }
            area.setText(op.viewRegion(reg));
        });

        validate.addActionListener(e -> {
            try {
                if (entered.getText().trim().isEmpty() || real.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(f, "Please enter both readings");
                    return;
                }
                int en = Integer.parseInt(entered.getText());
                int re = Integer.parseInt(real.getText());
                area.setText(op.validateReading(en, re));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Invalid reading input");
            }
        });

        setTariff.addActionListener(e -> {
            try {
                if (meter.getText().trim().isEmpty() || tariff.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(f, "Please enter meter code and tariff");
                    return;
                }
                long m = Long.parseLong(meter.getText());
                double t = Double.parseDouble(tariff.getText());
                area.setText(op.defineTariffForCustomer(m, t));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Invalid tariff input");
            }
        });

        cancel.addActionListener(e -> {
            try {
                if (cancelMeter.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(f, "Please enter meter code");
                    return;
                }
                long m = Long.parseLong(cancelMeter.getText());
                area.setText(op.cancelSubscription(m));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(f, "Invalid meter code");
            }
        });

        f.setVisible(true);
    }
}
