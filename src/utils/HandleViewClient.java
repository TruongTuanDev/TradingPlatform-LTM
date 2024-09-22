package utils;
import javax.swing.SwingUtilities;

import components.SignUpPanel;
import datahandle.DataAPI;
import views.*;
public class HandleViewClient {

	public static LoginView loginView;
	public static SignUpPanel loginPanelSignup;
	public static MarketView maketView;
	public static DataAPI dataAPI;

	public static enum Views{	
		LOGIN,LOGINPANELSIGNUP,MARKET
	}
	public static void closeView(Views viewName) {
		if(viewName != null) {
			switch (viewName) {
			case LOGIN: {
				loginView.dispose();
				break;
			}case LOGINPANELSIGNUP:{
				loginPanelSignup.setVisible(false);
				break;
			}
			
		}
	}
	}
	public static void openView(Views viewName) {
		if (viewName != null) {
			switch (viewName) {
			case LOGIN: {
				loginView = new LoginView();
				loginView.setVisible(true);
				break;
			}case MARKET: {
				dataAPI = new DataAPI();
		        SwingUtilities.invokeLater(() -> {
		        	maketView = new MarketView();
		            dataAPI.getListCoinTop(maketView);
		            dataAPI.getListGainerCoin(maketView);
		            dataAPI.getListVolumeCoin(maketView);
		            dataAPI.getListNewCoin(maketView);
		            maketView.setVisible(true);
		        });
				break;
			}
		}
	}

}
	
}

