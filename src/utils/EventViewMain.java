package utils;

import javax.swing.JPanel;

public class EventViewMain {
	public EventViewMain() {
	}
	public void openMenu(JPanel panelMenu) {
		int W = 200;
		int H = 1100;
		new Thread(new Runnable() {
			public void run() {
				if(panelMenu.getWidth() != 200) {
				for (int i = 99; i <= W; i++) {
					panelMenu.setSize(i, H);
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}).start();
	}

	public void closeMenu(JPanel panelMenu) {
		int W = 200;
		int H = 1100;
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = W; i > 99; i--) {
					panelMenu.setSize(i, H);
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();
	}


}
