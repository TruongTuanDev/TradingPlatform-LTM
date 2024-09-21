package dao;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DAO_Signup {
	public static String code;
	public void sendEmail(JPasswordField textPasswordCF, JPasswordField textPassword, JTextField textEmail, JTextField textUser_name) {
		if (!textPassword.getText().equals(textPasswordCF.getText())) {
			JOptionPane.showMessageDialog(null, "Passwords match");
		} else if (textUser_name.getText().equals("") || textPassword.getText().equals("")
				|| textPasswordCF.getText().equals("") || textEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please fill the full information");
		} else {
			Random random = new Random();
			char[] chars = "0123456789".toCharArray();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 5; i++) {
				char c = chars[random.nextInt(chars.length)];
				sb.append(c);
			}
			code = sb.toString();
			String to = textEmail.getText();
			String from = "hulosportshop@gmail.com";
			String title = "Code";
			Properties props = new Properties();
			props.put("mail.smtp.auth", true);
			props.put("mail.smtp.starttls.enable", true);
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.ssl.protocols", "TLSv1.2");
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("hulosportshop@gmail.com", "Ssmpkkxwjyqwqqle");
				}
			});
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject(title);
				message.setText(String.valueOf(code));
				Transport.send(message);
				JOptionPane.showMessageDialog(null, "Please wait for send Email");
			} catch (MessagingException mex) {
				JOptionPane.showMessageDialog(null, "Please re-enter ");
				mex.printStackTrace();
			}
		}
	}
}
