package utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;

public class Calender {
	
	public void Oclock(JLabel lableOclock) {
		new Thread() {
			public void run() {
				while(true) {
					Calendar ca = new GregorianCalendar();
					int hour   = ca.get(Calendar.HOUR);
					int minute = ca.get(Calendar.MINUTE);
					int second = ca.get(Calendar.SECOND);
					int AM_PM  = ca.get(Calendar.AM_PM);
					String day_Night;
					if (AM_PM == 1) {
						day_Night = "PM";						
					}else {
						day_Night = "AM";
						
					}
				String time ="   "+ hour+" : " + minute+" : "+second+" "+ day_Night;
				lableOclock.setText(time);
				}
			}
			
		}.start();
	}
	public void Date(JLabel lableDate) {
		new Thread() {
			public void run() {
				while(true) {
					Calendar ca = new GregorianCalendar();
					int day   = ca.get(Calendar.DAY_OF_MONTH);
					int month = ca.get(Calendar.MONTH);
					int year = ca.get(Calendar.YEAR);
					month = month +1;
				String date ="   "+ day+" : " + month +" : "+year;
				lableDate.setText(date);
				}
			}
			
		}.start();
	}


}
