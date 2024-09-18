package event;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.DAO_Signup;

public class Event_Signup {
	private DAO_Signup daoSignup = new DAO_Signup();
	public Event_Signup() {
	}
	public void sendEmail(JPasswordField textPasswordCF,JPasswordField textPassword, JTextField textEmail, JTextField textUser_name) {
		daoSignup.sendEmail(textPasswordCF, textPassword, textEmail, textUser_name);
	}

}

