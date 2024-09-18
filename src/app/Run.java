package app;

import javax.swing.JOptionPane;


import views.LoginView;

public class Run {
	//eclipse-workspace\JavaNam3\TradingPlatform
	public static void main(String[] args) {
		try {		
		LoginView lg =	new LoginView();
		lg.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error main");
			e.printStackTrace();
		}
	}

}