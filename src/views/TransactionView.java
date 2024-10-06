package views;
import javax.swing.*;

import controller.ExchangeController;
import controller.OrderController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionView extends JFrame {

    private JTextField txtDepositAmount;
    private JLabel lblBalance;
    private JComboBox<String> bankComboBox;
    public static JLabel lblAccountId;

    private double balance = 1000.0; 
    private JTextField txtWithdrawAmount;
    public static JTextField txtBalance;
    

    public TransactionView() {
    	lblAccountId = new JLabel();
        setTitle("Giao dịch Nạp/Rút tiền");
        setSize(869, 635); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        
        JPanel mainPanel = new JPanel(new GridLayout(4, 1)); 
        mainPanel.setBackground(new Color(30, 144, 255)); 

       
        JPanel bankPanel = new JPanel();
        bankPanel.setBackground(new Color(255, 248, 220)); 
        bankPanel.setBorder(BorderFactory.createTitledBorder(null, "Chọn ngân hàng", 
                2, 2, new Font("Arial", Font.BOLD, 16), Color.DARK_GRAY));
        
      
        String[] banks = {"Vietcombank", "Techcombank", "BIDV", "VPBank", "ACB"};
        bankComboBox = new JComboBox<>(banks);
        bankComboBox.setFont(new Font("Arial", Font.PLAIN, 20));
        
        JLabel label = new JLabel("Ngân hàng:", JLabel.CENTER);
        label.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bankPanel.add(label);
        bankPanel.add(bankComboBox);

       
        JPanel depositPanel = new JPanel();
        depositPanel.setBackground(new Color(255, 228, 196)); 
        depositPanel.setBorder(BorderFactory.createTitledBorder(null, "Nạp tiền", 
                2, 2, new Font("Arial", Font.BOLD, 16), Color.BLUE));
        
        txtDepositAmount = new JTextField(10);
        txtDepositAmount.setBounds(180, 56, 174, 30);
        txtDepositAmount.setFont(new Font("Arial", Font.PLAIN, 20));
        JButton btnDeposit = new JButton("Nạp tiền");
        btnDeposit.setBounds(412, 56, 143, 31);
        btnDeposit.setBackground(new Color(60, 179, 113));
        btnDeposit.setForeground(Color.WHITE); 
        btnDeposit.setFont(new Font("Arial", Font.BOLD, 20));

        btnDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Double quantityDeposit = Double.parseDouble(txtDepositAmount.getText());
                ExchangeController.depositCurency(quantityDeposit, lblAccountId.getText());
            }
        });
        depositPanel.setLayout(null);
        JLabel label_1 = new JLabel("Số tiền:", JLabel.CENTER);
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_1.setBounds(24, 59, 97, 23);
        depositPanel.add(label_1);
        depositPanel.add(txtDepositAmount);
        depositPanel.add(btnDeposit);

       
        JPanel withdrawPanel = new JPanel();
        withdrawPanel.setBackground(new Color(255, 228, 196));
        withdrawPanel.setBorder(BorderFactory.createTitledBorder(null, "Rút tiền", 
                2, 2, new Font("Arial", Font.BOLD, 16), Color.RED));
        JButton btnWithdraw = new JButton("Rút tiền");
        btnWithdraw.setBounds(413, 48, 144, 30);
        btnWithdraw.setBackground(new Color(220, 20, 60));
        btnWithdraw.setForeground(Color.WHITE);
        btnWithdraw.setFont(new Font("Arial", Font.BOLD, 20));

        btnWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Double quantityWithdraw = Double.parseDouble(txtWithdrawAmount.getText());
                ExchangeController.withdrawCurency(quantityWithdraw, lblAccountId.getText());
            }
        });
        withdrawPanel.setLayout(null);
        withdrawPanel.add(btnWithdraw);

       
        JPanel balancePanel = new JPanel();
        balancePanel.setBackground(new Color(255, 250, 205)); 
        balancePanel.setLayout(null);
        lblBalance = new JLabel("Số dư hiện tại:");
        lblBalance.setBounds(186, 49, 138, 24);
        lblBalance.setFont(new Font("Arial", Font.BOLD, 20));
        lblBalance.setForeground(Color.BLACK);
        balancePanel.add(lblBalance);

        
        mainPanel.add(bankPanel); 
        mainPanel.add(depositPanel);
        mainPanel.add(withdrawPanel);
        
        JLabel label_1_1 = new JLabel("Số tiền:", SwingConstants.CENTER);
        label_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_1_1.setBounds(25, 55, 97, 23);
        withdrawPanel.add(label_1_1);
        
        txtWithdrawAmount = new JTextField(10);
        txtWithdrawAmount.setFont(new Font("Arial", Font.PLAIN, 20));
        txtWithdrawAmount.setBounds(180, 48, 174, 30);
        withdrawPanel.add(txtWithdrawAmount);
        mainPanel.add(balancePanel);
        
        JLabel lblUsd = new JLabel(" USD");
        lblUsd.setForeground(Color.BLACK);
        lblUsd.setFont(new Font("Arial", Font.BOLD, 20));
        lblUsd.setBounds(544, 49, 53, 24);
        balancePanel.add(lblUsd);
        
        txtBalance = new JTextField(10);
        txtBalance.setFont(new Font("Arial", Font.PLAIN, 20));
        txtBalance.setBounds(334, 43, 212, 30);
        balancePanel.add(txtBalance);

        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }



    // Hàm định dạng số tiền
    private String formatCurrency(double amount) {
        return String.format("%,.2f", amount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TransactionView transactionView = new TransactionView();
                transactionView.setVisible(true);
            }
        });
    }
}
