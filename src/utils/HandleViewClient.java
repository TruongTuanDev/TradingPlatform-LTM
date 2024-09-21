package utils;
import components.SignUpPanel;
import views.*;
public class HandleViewClient {

	public static LoginView loginView;
	public static SignUpPanel loginPanelSignup;
	
	public static enum Views{
		LOGIN,LOGINPANELSIGNUP
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
			}
		}
	}
}
}

