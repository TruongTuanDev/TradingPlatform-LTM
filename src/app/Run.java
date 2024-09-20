package app;

import javax.swing.JOptionPane;

import socket.SocketHandle;
import views.LoginView;

public class Run {
	//eclipse-workspace\JavaNam3\TradingPlatform
	public static SocketHandle socketHandle;
	public static void main(String[] args) {
		try {		
		LoginView lg =	new LoginView();
		lg.setVisible(true);
		socketHandle = new SocketHandle();
		socketHandle.setUpSocket();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error main");
			e.printStackTrace();
		}
	}
}