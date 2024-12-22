package controller;

import socket.SocketHandle;

public class ExchangeController {
	
	public static void depositCurency(double quantityCurency, String idWallets) {
		if (SocketHandle.getDaOutputStream() != null) {
		    SocketHandle.getDaOutputStream().println("request-deposit,"+idWallets +","+quantityCurency);
		} else {
		    System.err.println("Output stream is not ready. Socket may not be initialized yet.");
		}
	}
	public static void withdrawCurency(double quantityCurency, String idWallets) {
		if (SocketHandle.getDaOutputStream() != null) {
		    SocketHandle.getDaOutputStream().println("request-withdraw,"+quantityCurency+","+idWallets);
		} else {
		    System.err.println("Output stream is not ready. Socket may not be initialized yet.");
		}
	}
	

}
