package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.border.MatteBorder;

import components.SignUpPanel;
import controller.AuthController;
import utils.*;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

public class LoginView extends JFrame implements ActionListener{
	private static JPanel panelBackground;
	JButton btnLogin,btnSignUp;
	JToggleButton btnshowPassword;
	JLabel lblNotify, lblSp, lblUser,lableOclock;
	JCheckBox chckbxShowPassword;
	private  JTextField textUser;
	private  JPasswordField textPassword;
	private SignUpPanel panelSP;
	public static JPanel panelLg;
	private Calender eventCalender;
	private JLabel lableDate;
	public static JLabel lblpositionst;
	
	public static String namelg;
	public LoginView() {
		initComponents();
		eventCalender.Oclock(lableOclock);
		eventCalender.Date(lableDate);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(LoginView.class.getResource("/Item/logonew.png")));
		lblNewLabel_7.setBounds(70, 70, 410, 339);
		panelBackground.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Crypto Trading");
		lblNewLabel_8.setForeground(new Color(255, 0, 0));
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_8.setBounds(216, 426, 207, 39);
		panelBackground.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Trade cryptocurrencies with ease on our platform");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(150, 486, 400, 24);
		panelBackground.add(lblNewLabel_9);

		JLabel lblNewLabel_9_1 = new JLabel("where security and real-time transactions are guaranteed!");
		lblNewLabel_9_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9_1.setBounds(130, 520, 500, 24);
		panelBackground.add(lblNewLabel_9_1);
	
	}
	private void initComponents() {
		
		panelSP = new SignUpPanel(this);
		panelSP.setBounds(663, 58, 549, 668);
		panelLg = new JPanel();
		eventCalender = new Calender();
		panelLg.setBackground(new Color(255, 255, 255));
		this.setTitle("LOGIN SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 0, 1400, 763);
		panelBackground = new DrawPanel(50, 100, 1200, 900);
		panelBackground.setLayout(null);
	    panelBackground.add(panelSP);
		panelSP.setVisible(false);
		panelBackground.add(panelLg);
		getContentPane().add(panelBackground);
		
		
		panelLg.setBounds(663, 58, 549, 668);
		panelLg.setLayout(null);
		//panelLg.setBackground(new java.awt.Color(0, 0, 0, 80));
		JLabel lblNewLabel_1 = new JLabel("WELCOME TO OUR APPLICATION");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_1.setForeground(Color.red);
		lblNewLabel_1.setBounds(80, 28, 442, 50);
		panelLg.add(lblNewLabel_1);
		
		textUser = new JTextField();
		textUser.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textUser.setBounds(104, 259, 316, 27);
		textUser.setForeground(new Color(0, 0, 0));
		textUser.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 255, 255)));

		panelLg.add(textUser);

		textPassword = new JPasswordField("");
		textPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textPassword.setBounds(104, 324, 257, 29);
		textPassword.setEchoChar('*');
		textPassword.setOpaque(false);
		textPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 255, 255)));
		panelLg.add(textPassword);
		

		JLabel lblNotify = new JLabel("");
		lblNotify.setForeground(Color.RED);
		lblNotify.setFont(new Font(null, Font.ITALIC, 15));
		lblNotify.setBounds(150, 363, 155, 19);
		panelLg.add(lblNotify);
		JLabel lblSp = new JLabel("Support  0898604143");
		lblSp.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSp.setBounds(210, 642, 149, 19);
		panelLg.add(lblSp);

		btnLogin = new JButton("LOG IN");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 128, 64));
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnLogin.setSize(347, 30);
		btnLogin.setLocation(104, 422);
		btnLogin.addActionListener(this);
		panelLg.add(btnLogin);

		JLabel lblForgotpassword = new JLabel("F͟o͟r͟g͟o͟t͟ p͟a͟s͟s͟w͟o͟r͟d͟ ?");
		lblForgotpassword.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblForgotpassword.setBounds(316, 363, 125, 19);
		lblForgotpassword.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		panelLg.add(lblForgotpassword);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel.setBounds(231, 139, 90, 58);
		panelLg.add(lblNewLabel);

		JLabel lblIconlg = new JLabel("");
		lblIconlg.setBounds(234, 124, 70, 70);
		//lblIconlg.setIcon(iconlg);
		panelLg.add(lblIconlg);
		
		JLabel lblNewLabel_2 = new JLabel("Or");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(264, 480, 25, 13);
		panelLg.add(lblNewLabel_2);
		
		btnSignUp = new JButton("Creat Account");
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setBackground(new Color(0, 128, 64));
		btnSignUp.addActionListener(this);
		btnSignUp.setBounds(104, 513, 347, 30);
		panelLg.add(btnSignUp);
		btnSignUp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("Or sign up using");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(231, 579, 90, 13);
		panelLg.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(LoginView.class.getResource("/Item/logo-fb.png")));
		lblNewLabel_4.setBounds(210, 602, 39, 30);
		panelLg.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(LoginView.class.getResource("/Item/logo-tweet.png")));
		lblNewLabel_4_1.setBounds(250, 602, 39, 30);
		panelLg.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setIcon(new ImageIcon(LoginView.class.getResource("/Item/logo-gg.png")));
		lblNewLabel_4_2.setBounds(293, 602, 39, 30);
		panelLg.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_5 = new JLabel("User name");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(104, 230, 90, 19);
		panelLg.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Password");
		lblNewLabel_5_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5_1.setBounds(104, 306, 90, 19);
		panelLg.add(lblNewLabel_5_1);
		
		btnshowPassword = new JToggleButton("");
		btnshowPassword.setIcon(new ImageIcon(LoginView.class.getResource("/Item/showicon.png")));
		btnshowPassword.setBounds(361, 324, 59, 29);
		btnshowPassword.addActionListener(this);
		btnshowPassword.setBackground(Color.white);
		btnshowPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 255, 255)));
		panelLg.add(btnshowPassword);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(LoginView.class.getResource("/Item/support.png")));
		lblNewLabel_6.setBounds(155, 632, 45, 36);
		panelLg.add(lblNewLabel_6);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1421, 60);
		panelBackground.add(panel);
		panel.setLayout(null);
		
		lableOclock = new JLabel("");
		lableOclock.setForeground(new Color(255, 255, 255));
		lableOclock.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lableOclock.setBounds(1133, 10, 243, 40);
		panel.add(lableOclock);
		
		lableDate = new JLabel("");
		lableDate.setForeground(new Color(255, 255, 255));
		lableDate.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lableDate.setBounds(54, 5, 187, 40);
		panel.add(lableDate);
		
		JLabel lblNewLabel_10 = new JLabel("Double2T");
		lblNewLabel_10.setBounds(873, 10, 200, 40);
		panel.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Harrington", Font.PLAIN, 30));
		lblNewLabel_10.setForeground(new Color(255, 0, 0));
		
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnLogin) {
			AuthController.login(textUser.getText(), textPassword.getText());
		}else if(e.getSource()== btnSignUp) {
			panelLg.setVisible(false);
			panelSP.setVisible(true);
		}else if(e.getSource() == btnshowPassword) {
			if (btnshowPassword.isSelected()) {
				textPassword.setEchoChar((char) 0);
//				btnshowPassword.setIcon(new ImageIcon(Login.class.getResource("/Item/hineicon.png")));
	        } else {
	        	textPassword.setEchoChar('*');
//	    		btnshowPassword.setIcon(new ImageIcon(Login.class.getResource("/Item/showicon.png")));
	        }
		}
	}
}
