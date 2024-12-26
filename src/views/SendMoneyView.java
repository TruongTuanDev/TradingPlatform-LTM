package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.SendMoneyController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendMoneyView extends JPanel {
    public static JLabel labelName, labelBalance;
    private JTextField usernameField, amountField;
    private JButton sendMoneyButton;
    

    public SendMoneyView() {
    	OrderView orderViews = new OrderView();
    
    	
        setBackground(new Color(255, 255, 255)); // Màu trắng
        setLayout(null);

        // Top Navigation Bar
        JPanel navBar = new JPanel();
        navBar.setBounds(0, 0, 1447, 23);
        navBar.setBackground(new Color(0, 102, 204));
        navBar.setLayout(null);

        // Profile Section
        JPanel profilePanel = new JPanel();
        profilePanel.setBounds(10, 0, 485, 23);
        profilePanel.setBackground(new Color(0, 102, 204));

        labelName = new JLabel();

        
        labelName.setBounds(125, 5, 130, 13);
        labelName.setForeground(Color.WHITE);

        JLabel balanceLabel = new JLabel("Balance: ");
        balanceLabel.setBounds(283, 5, 59, 13);
        balanceLabel.setForeground(Color.WHITE);

        labelBalance = new JLabel("$1000");
        labelBalance.setBounds(385, 5, 130, 13);
        labelBalance.setForeground(Color.WHITE);
       
        profilePanel.setLayout(null);
        profilePanel.add(labelName);
        profilePanel.add(balanceLabel);
        profilePanel.add(labelBalance);

        navBar.add(profilePanel);
        
                JLabel usernameLabel = new JLabel("Username: ");
                usernameLabel.setBounds(10, 0, 91, 23);
                profilePanel.add(usernameLabel);
                usernameLabel.setForeground(Color.WHITE);
        add(navBar);

        // Content Panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBounds(0, 23, 1447, 692);
        contentPanel.setBackground(new Color(255, 255, 255));

        // Send Money Section
        JPanel sendMoneyPanel = new JPanel();
        sendMoneyPanel.setBackground(new Color(255, 255, 255));
        sendMoneyPanel.setBorder(BorderFactory.createTitledBorder("Send Money"));

        JLabel enterUsernameLabel = new JLabel("Enter Recipient Username:");
        enterUsernameLabel.setBounds(144, 40, 161, 41);
        usernameField = new JTextField();
        usernameField.setBounds(360, 51, 175, 30);
        
        JLabel enterAmountLabel = new JLabel("Enter Amount to Send:");
        enterAmountLabel.setBounds(144, 90, 182, 41);
        amountField = new JTextField();
        amountField.setBounds(360, 101, 175, 30);

        sendMoneyButton = new JButton("Send Money");
        sendMoneyButton.setBounds(345, 222, 135, 29);
        sendMoneyButton.setBackground(new Color(0, 153, 51));
        sendMoneyButton.setForeground(Color.WHITE);

        JLabel statusLabel = new JLabel(); // Display status of the transaction
        statusLabel.setBounds(309, 121, 214, 56);
        statusLabel.setForeground(Color.RED);
        sendMoneyPanel.setLayout(null);

        sendMoneyPanel.add(enterUsernameLabel);
        sendMoneyPanel.add(usernameField);
        sendMoneyPanel.add(enterAmountLabel);
        sendMoneyPanel.add(amountField);
        JLabel label = new JLabel();
        label.setBounds(319, 141, 161, 49);
        sendMoneyPanel.add(label); // Placeholder
        sendMoneyPanel.add(sendMoneyButton);
        JLabel label_1 = new JLabel();
        label_1.setBounds(6, 214, 214, 56);
        sendMoneyPanel.add(label_1); // Placeholder
        sendMoneyPanel.add(statusLabel);

        contentPanel.add(sendMoneyPanel, BorderLayout.CENTER);
        add(contentPanel);
        

        // Add action listener for Send Money button
        sendMoneyButton.addActionListener(new ActionListener() {
        	  
            @Override
            public void actionPerformed(ActionEvent e) {
                String recipient = usernameField.getText();
                String amountText = amountField.getText();

                try {
                    double amount = Double.parseDouble(amountText);
                    double currentBalance = Double.parseDouble(labelBalance.getText().replace("$", ""));

                    if (amount <= 0) {
                        statusLabel.setText("Số lượng không hợp lệ");
                    } else if (amount > currentBalance) {
                        statusLabel.setText("Số dư không đủ.");
                    } else {    	
                    	SendMoneyController.sendMoney(recipient, amount);
                        currentBalance -= amount;
                       
                       
                    }
                } catch (NumberFormatException ex) {
                    statusLabel.setText("Invalid amount entered.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Markets Overview");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            OrderView orderView = new OrderView();
            SendMoneyView marketView = new SendMoneyView();
            frame.getContentPane().add(marketView);

            frame.setVisible(true);
        });
    }
}
