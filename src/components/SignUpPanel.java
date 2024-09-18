package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import controller.AuthController;
import event.Event_Signup;
import views.LoginView;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SignUpPanel extends JPanel{
	JButton btnContinue,btnAccepct;
	public static JPasswordField textPassSp,textPasswordCF;
	private JTextField textEmail,textUser,textIDCUS,textXN;	
	private Event_Signup eventSignUp;
	private LoginView login;
	JPanel panelAcep,panelAcept,panel;
	
	public SignUpPanel() {
		initcomponents();
		
	
	}
	private void initcomponents() {
		eventSignUp = new Event_Signup();
		setBounds(663, 0, 549, 729);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		panel = new JPanel();
		panel.setBounds(0, 0, 549, 729);
		add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panelSg = new JPanel();
		panelSg.setBackground(new Color(255, 255, 255));
		panelSg.setLayout(null);
		panel.add(panelSg, "name_415084935774100");
		//loginXN = new Login_PanelXN();
		
		JPanel panelBa = new JPanel();
		panelBa.setBackground(new Color(0, 0, 0));
		panelBa.setBounds(0, 0, 549, 59);
		panelSg.add(panelBa);
		panelBa.setLayout(null);
		
		JLabel lbls = new JLabel("Sign up for an account ");
		lbls.setBounds(130, 10, 262, 28);
		panelBa.add(lbls);
		lbls.setForeground(new Color(255, 255, 255));
		lbls.setBackground(new Color(255, 255, 255));
		lbls.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SignUpPanel.class.getResource("/Item/left-arrow.png")));
		lblNewLabel.setBounds(10, 10, 66, 39);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				login.panelLg.setVisible(true);
			}
		});
		panelBa.add(lblNewLabel);
				
		

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 60, 549, 13);
		panelSg.add(separator);

		JLabel lblp = new JLabel("Password");
		lblp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblp.setBounds(22, 328, 131, 24);
		panelSg.add(lblp);

		textPassSp = new JPasswordField();
		textPassSp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textPassSp.getText().equals("Password is not empty.")||
					textPassSp.getText().equals("This password is invalid.")) {
					textPassSp.setText("");
					textPassSp.setEchoChar('*');
					}
			}
			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		textPassSp.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textPassSp.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 255, 255)));
		textPassSp.setBounds(22, 362, 517, 28);
		panelSg.add(textPassSp);

		JLabel lblc = new JLabel("Confirm The Password");
		lblc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblc.setBounds(22, 419, 186, 28);
		panelSg.add(lblc);

		textPasswordCF = new JPasswordField();
		textPasswordCF.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textPasswordCF.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 255, 255)));
		textPasswordCF.setBounds(22, 457, 517, 28);
		textPasswordCF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(!textPasswordCF.getText().equals(textPassSp.getText())) {
					JOptionPane.showMessageDialog(null,"Confirm password do not match");
					textPasswordCF.setText("");
				}
			}
		});
		panelSg.add(textPasswordCF);

		btnContinue = new JButton();
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pscf =  textPasswordCF.getText();
				String ps = textPassSp.getText();
				if(pscf.equals(ps)) {		
					eventSignUp.sendEmail(textPasswordCF, textPassSp, textEmail, textUser);
					CardLayout cardLayout = (CardLayout) panel.getLayout();
					cardLayout.next(panel);	
					}	
				if(pscf.equals(ps)) {		
				
				CardLayout cardLayout = (CardLayout) panel.getLayout();
				cardLayout.next(panel);	
				}	
			}
		});
		btnContinue.setForeground(new Color(255, 255, 255));
		btnContinue.setText("CONTINUE");
		btnContinue.setBackground(new Color(0, 128, 64));
		btnContinue.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnContinue.setBounds(204, 621, 157, 28);
		panelSg.add(btnContinue);

		JLabel lblN = new JLabel("User Name");
		lblN.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblN.setBounds(22, 240, 151, 24);
		panelSg.add(lblN);

		textUser = new JTextField();
		textUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textUser.getText().equals("User is not empty.")) {
					textUser.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				
				if(textUser.getText().equals("")) {
					textUser.setText("User is not empty.");
				}
				
			}
		});
		textUser.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textUser.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 255, 255)));
		textUser.setBounds(22, 274, 517, 28);
		panelSg.add(textUser);
		
		JLabel lblPinCode = new JLabel("Email");
		lblPinCode.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPinCode.setBounds(22, 518, 131, 24);
		panelSg.add(lblPinCode);
		
		textEmail = new JTextField();
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
		textEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textEmail.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 255, 255)));
		textEmail.setBounds(22, 552, 517, 28);
		panelSg.add(textEmail);
		
		textIDCUS = new JTextField();
		textIDCUS.setEditable(false);
		textIDCUS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textIDCUS.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 255, 255)));
		textIDCUS.setBounds(22, 172, 123, 28);
		panelSg.add(textIDCUS);
		
		//Panel xacnhan
		
		panelAcep = new JPanel();
		panelAcep.setBackground(new Color(0, 0, 0));
		panelAcep.setBounds(0, 0, 549, 350);
		panelAcep.setVisible(false);
		panelAcep.setLayout(null);
		panel.add(panelAcep);
		
		JLabel lblNewLabel_2 = new JLabel(" Enter the verification code sent to you");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(127, 57, 325, 42);
		panelAcep.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("either by email depending on your Personal Area security type");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(22, 109, 527, 27);
		panelAcep.add(lblNewLabel_3);
		
		textXN = new JTextField();
		textXN.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		textXN.setBounds(196, 192, 136, 27);
		panelAcep.add(textXN);
		textXN.setColumns(10);
		
	    btnAccepct = new JButton("Accepct");
		btnAccepct.setBackground(new Color(0, 255, 0));
		btnAccepct.setForeground(new Color(255, 255, 255));
		btnAccepct.setBounds(218, 252, 85, 21);
		btnAccepct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AuthController.register(textPassSp.getText(),textEmail.getText(), textUser.getText());
				JOptionPane.showMessageDialog(null, "Register Success");
			}
			});
		panelAcep.add(btnAccepct);
		
		JLabel lblNewLabel_4 = new JLabel("CODE");
		lblNewLabel_4.setForeground(new Color(0, 255, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(229, 153, 76, 27);
		panelAcep.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout cardLayout = (CardLayout) panel.getLayout();
				cardLayout.next(panel);
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(SignUpPanel.class.getResource("/Item/left-arrow.png")));
		lblNewLabel_1.setBounds(22, 570, 69, 53);
		panelAcep.add(lblNewLabel_1);
		
	}
	
}
	
