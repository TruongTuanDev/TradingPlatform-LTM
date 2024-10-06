package components;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import utils.DrawPanel;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
public class AddInformatin extends JFrame implements ActionListener{
	private JPanel contentPane;
	JPanel panel;
	private JTextField textEmail;
	private JPasswordField textPassword;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_3;
	private JLabel lblImage;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textPhone;
	private JButton btnBrows,btnUpdate,btnCancel,btnClear;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddInformatin frame = new AddInformatin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AddInformatin() {
		setUndecorated(true);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		getContentPane().add(contentPane);
		
		panel = new DrawPanel();
		panel.setBounds(0, 0, 716, 678);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(185, 27, 249, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(76, 226, 94, 25);
		panel.add(lblNewLabel_1);
		
		textEmail = new JTextField();
		textEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
		textEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textEmail.getText().equals("Email is not empty.") ||
				   textEmail.getText().equals("This email is invalid.")) 
				{
					textEmail.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		textEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textEmail.setBounds(220, 178, 205, 25);
		textEmail.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 255, 255)));
		panel.add(textEmail);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(76, 175, 85, 25);
		panel.add(lblNewLabel_1_1);
		
		textPassword = new JPasswordField();
		textPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textPassword.getText().equals("Password comfirm is not empty.")||
				    textPassword.getText().equals("Confirm password do not match")) {
					 textPassword.setText("");
					 textPassword.setEchoChar('*');
						}
			}
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		textPassword.setEchoChar('*');
		textPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textPassword.setBounds(220, 229, 205, 25);
		textPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 255, 255)));
		textPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		panel.add(textPassword);

		
		lblNewLabel_1_2 = new JLabel("Full Name");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(76, 290, 85, 25);
		panel.add(lblNewLabel_1_2);
		
		lblNewLabel_1_3 = new JLabel("Address");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(76, 353, 85, 25);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Phone Number");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3_1.setBounds(76, 413, 134, 25);
		panel.add(lblNewLabel_1_3_1);
		
		lblImage = new JLabel("");
		lblImage.setBounds(501, 191, 144, 150);
		lblImage.setBorder(new LineBorder(Color.darkGray));
		panel.add(lblImage);
		
		textName = new JTextField();
		textName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textName.getText().equals("Full name is not empty.") ||
				   textName.getText().equals("This name is invalid.")) 
				  {
					textName.setText("");
				  }
			}
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		textName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textName.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 255, 255)));
		textName.setBounds(220, 295, 205, 25);
		panel.add(textName);
		
		textAddress = new JTextField();
		textAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textAddress.getText().equals("Address is not empty.") ||
				   textAddress.getText().equals("This address is invalid.")) 
					 {
					textAddress.setText("");
					 }
			}
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		textAddress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textAddress.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 255, 255)));
		textAddress.setBounds(220, 358, 205, 25);
		panel.add(textAddress);
		
		textPhone = new JTextField();
		textPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textPhone.getText().equals("Phone Number is not empty.") ||
					textPhone.getText().equals("This phone number is invalid.")) 
					 {
					textPhone.setText("");
					 }
			}
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		textPhone.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textPhone.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 255, 255)));
		textPhone.setBounds(220, 413, 205, 25);
		panel.add(textPhone);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(new Color(0, 255, 0));
		btnUpdate.setBackground(new Color(0, 0, 0));
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUpdate.setBounds(345, 515, 114, 32);
		btnUpdate.addActionListener(this);
		panel.add(btnUpdate);
		
		btnBrows = new JButton("BROWS");
		btnBrows.setForeground(Color.GREEN);
		btnBrows.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBrows.setBackground(Color.BLACK);
		btnBrows.setBounds(520, 410, 114, 32);
		btnBrows.addActionListener(this);
		panel.add(btnBrows);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setForeground(Color.GREEN);
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCancel.setBackground(new Color(255, 255, 255));
		btnCancel.setBounds(96, 515, 114, 32);
		btnCancel.addActionListener(this);
		panel.add(btnCancel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(76, 121, 85, 25);
		panel.add(lblNewLabel_1_1_1);

		
		btnClear = new JButton("CLEAR");
		btnClear.setForeground(Color.GREEN);
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnClear.setBackground(Color.BLACK);
		btnClear.setBounds(220, 515, 114, 32);
		panel.add(btnClear);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==  btnUpdate) {
		}else if(e.getSource() == btnBrows) {
		}else if(e.getSource() == btnCancel) {
			setVisible(false);
		}else if(e.getSource() == btnClear) {
		}
	}			
}
