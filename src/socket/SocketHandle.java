package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.ResponseReceiver;
import utils.HandleViewClient;
import views.LoginView;

public class SocketHandle {
	public static BufferedReader inputReader;
	public static PrintWriter outputWriter;
	public static Socket socket;
	private ResponseReceiver responseReceiver;
	private LoginView loginView;
	
	public SocketHandle() {
	}
	public SocketHandle(ResponseReceiver responseReceiver) {
		this.responseReceiver = responseReceiver;
	}

	public static Socket getSocket() {
		return socket;
	}

	public static BufferedReader getDataInputStream() {
		return inputReader;
	}
	public static PrintWriter getDaOutputStream() {
		return outputWriter;
	}
	public void setUpSocket() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					socket = new Socket("192.168.1.82", 12345);
					inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					outputWriter = new PrintWriter(socket.getOutputStream(), true); 
					String message;		
					 while (true) {
	                        message = inputReader.readLine();
	                        System.out.println("Nhận về: " + message);
	                        if (message.equals("End")) {
	                            break;
	                        }
	                        responseFromServer(message);
	                    }
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		};	
		thread.start();
	}	
	public void responseFromServer(String message) {
        String[] messageSplit = message.split(",");

        switch (messageSplit[0].trim()) {
            case "login-succses": {
                if (messageSplit[2].equals("admin")) {
                   
                } else {
                  
                }
                break;
            }
            case "login-false": {
                System.out.println("Đăng nhập thất bại");
               
                break;
            }
            case "register-succses": {
                System.out.println("Đăng ký thành công");
                HandleViewClient.openView(HandleViewClient.Views.LOGIN);
                break;
            }
            case "username-match": {
                responseReceiver.onReceiveResponse("username-match");
                System.out.println("Tên người dùng đã tồn tại");
                break;
            }
            default:
                System.out.println("Phản hồi không xác định: " + message);
                break;
        }
    }
	

}
