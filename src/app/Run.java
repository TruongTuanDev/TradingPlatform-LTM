package app;

import javax.swing.JOptionPane;

import socket.SocketHandle;
import utils.HandleViewClient;
import views.LoginView;

public class Run {
	//eclipse-workspace\JavaNam3\TradingPlatform
	public static SocketHandle socketHandle;
	public static void main(String[] args) {
		try {		  
		socketHandle = new SocketHandle();
		socketHandle.setUpSocket();
		HandleViewClient.openView(HandleViewClient.Views.LOGIN);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error main");
			e.printStackTrace();
		}
	}

}