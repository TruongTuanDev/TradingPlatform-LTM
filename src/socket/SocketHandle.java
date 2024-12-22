package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.ResponseReceiver;
import model.DataItem;
import model.Token;
import model.Wallet;
import utils.HandleViewClient;
import views.LoginView;
import views.MarketView;
import views.OrderView;
import views.TransactionView;

public class SocketHandle {
 
	public static enum Respose{	
		LOGIN_FALSE,
		REGISTER_SUCCESS,
		REGISTER_FALSE,
		RE,
		BUY_SUCCESS,
		SELL_SUCCESS,
		BUY_FALSE,
		SELL_FALSE,
		DIPOSIT_SUCCESS,
		DIPOSIT_FALSE,
		WITHDRAW_SUCCESS,
		WITHDRAW_FALSE,
		BALANCE_SUCCESS,
		USERNAME_MATCH
	}
	
	public static BufferedReader inputReader;
	public static PrintWriter outputWriter;
	public static Socket socket;
	private ResponseReceiver responseReceiver;
	private LoginView loginView;
	private ObjectInputStream objectIn;
	public static List<Token> receivedTokenList;
	
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
	        @SuppressWarnings("unchecked")
			@Override
	        public void run() {
	            try {
	                socket = new Socket("localhost", 12345);
	                ObjectInputStream objectReader = new ObjectInputStream(socket.getInputStream());
	                outputWriter = new PrintWriter(socket.getOutputStream(), true);

	                while (true) {
	                    Object receivedData = objectReader.readObject();
	                    if (receivedData instanceof String) {
	                        String message = (String) receivedData;
	                        System.out.println("Nhận về: " + message);
	                        responseFromServer(message);
//	                        responseFromServer(message);
	                    } else if (receivedData instanceof List<?>) {
	                    	String message="login-success, ";
	                    	
	                    	System.out.println("Nhận list: ");
	                        receivedTokenList = (List<Token>) receivedData;
	                        System.out.println("Received token list: " + receivedTokenList);
	                    }else {
	                    	System.out.println("Nhận list: ");
	                    }
	                }
	            } catch (UnknownHostException e) {
	                e.printStackTrace();
	            } catch (IOException | ClassNotFoundException e) {
	                e.printStackTrace();
	            }
	        } 
	    };  
	    thread.start();
	}

	
	public List<Token> getListToken(List<Token> list){
		List<Token> listToken = list;
		return listToken
			;
	}
	public void responseFromServer(String message) {
        String[] messageSplit = message.split(",");
        switch (messageSplit[0].trim()) {
        case "login-success": {
			JOptionPane.showMessageDialog(null, "Đăng nhập thành công");          	 
        	 HandleViewClient.closeView(HandleViewClient.Views.LOGIN);
             HandleViewClient.openView(HandleViewClient.Views.MAINVIEW);
             if(messageSplit[1] != null) {
            	 String userName = messageSplit[1];
            	 String balance = messageSplit[2];
                    	 SwingUtilities.invokeLater(() -> {          	
                             MarketView.labelName.setText(userName);
                             MarketView.lableBalance.setText(balance);
                             
         		        });
}else {
            	 MarketView.labelName.setText("Name: Anonymus");
             }
            
            break;
        }
        case "login-false": {
			JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");          	 
            System.out.println("Đăng nhập thất bại");
           
            break;
        }
        case "register-success": {
            System.out.println("Đăng ký thành công");
			JOptionPane.showMessageDialog(null, "Đăng ký thành công");          	 
            HandleViewClient.openView(HandleViewClient.Views.LOGIN);
            break;
        } case "register-false": {
            System.out.println("Đăng ký thất bại");
			JOptionPane.showMessageDialog(null, "Đăng ký thất bại");          	 
            break;
        }
        case "getlistcoin" :{
        	
        	break;
        }
        case "buy-success": {
            System.out.println("Mua token thành công");
			JOptionPane.showMessageDialog(null, "Mua token thành công");          	 
            break;
        }case "sell-success": {
            System.out.println("Bán token thành công");
			JOptionPane.showMessageDialog(null, "Bán token thành công");          	 
            break;
        } case "buy-false": {
            System.out.println("Mua token thất bại");
			JOptionPane.showMessageDialog(null, "Mua token thất bại");          	 
            break;
        }case "sell-false": {
            System.out.println("Bán token thất bại");
			JOptionPane.showMessageDialog(null, "Bán token thất bại");          	 
            break;
        }case "deposit-success": {
            System.out.println("Nạp tiền thành công");
			JOptionPane.showMessageDialog(null, "Nạp tiền thành công");   
			TransactionView.txtBalance.setText(messageSplit[2]);
            break;
        } case "diposit-false": {
            System.out.println("Nạp tiền thất bại");
			JOptionPane.showMessageDialog(null, "Số tiền nạp không hợp lệ");          	 
            break;
        }case "withdraw-success": {
            System.out.println("Rút tiền thành công");
			JOptionPane.showMessageDialog(null, "Rút tiền thành công"); 
			TransactionView.txtBalance.setText(messageSplit[2]);
            break;
        } case "withdraw-false": {
            System.out.println("Rút tiền thất bại");
			JOptionPane.showMessageDialog(null, "Số dư không đủ");  
            break;
        }case "Balance-success": {
            System.out.println(messageSplit[1]);
            TransactionView.txtBalance.setText(messageSplit[1]);        	 
            break;
        }case "quantity_curency-success": {
            System.out.println(messageSplit[1]);
            OrderView.lblAvbUSD_1.setText(messageSplit[2]);        	 
            break;
        }
            case "username-match": {
            	try {
					List<Wallet> walletList = (List<Wallet>) objectIn.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//                responseReceiver.onReceiveResponse("username-match");
//                System.out.println("Tên người dùng đã tồn tại");
                break;
            }
            default:
                System.out.println("Phản hồi không xác định: " + message);
                break;
        }
    }
}