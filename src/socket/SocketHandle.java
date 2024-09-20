package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import controller.ResponseReceiver;

public class SocketHandle {
	public static BufferedReader inputReader;
	public static PrintWriter outputWriter;
	public static Socket socket;
	private ResponseReceiver responseReceiver;
	
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
					socket = new Socket("localhost", 9999);
					inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					outputWriter = new PrintWriter(socket.getOutputStream(), true); 
					String message;		
					while (true) {
						message = inputReader.readLine();
						System.out.println("Nhan ve : "+message);
						if (message.equals("End")) {
							break;
						}
						String[] mesageSlip = message.split(",");
						switch (mesageSlip[0].trim()) {
						case "login-succses": {
							System.out.println("Dang nhap thanh cong");
							break;
						}case "login-false" :{
							System.out.println("Dang nhap that bai");
							break;
						}case "register-succses" :{
							System.out.println("Dang Ki thanh cong");
							break;
						}
						}
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
	

}
