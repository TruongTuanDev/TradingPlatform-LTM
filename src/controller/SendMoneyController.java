package controller;

import socket.SocketHandle;

public class SendMoneyController {
	public static void sendMoney(String userName,Double quantity) {	
		SocketHandle.getDaOutputStream().println("request-sendmoney,"+userName+","+quantity);
	}
	}

