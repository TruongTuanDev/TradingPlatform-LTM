package controller;

import socket.SocketHandle;

public class OrderController {
	
	public static void buyCoin(
			double price,
			double quantity_curency,
			String symbol,
			String buyDate,
			String accountID
			) {
		if (SocketHandle.getDaOutputStream() != null) {
		    SocketHandle.getDaOutputStream().println("request-buy-coin,"+price+","+quantity_curency+","+symbol+","+buyDate+","+accountID);
		} else {
		    System.err.println("Output stream is not ready. Socket may not be initialized yet.");
		}
	}
	public static void sellCoin(
			double price,
			double quantity,
			double quantity_curency,
			String symbol,
			String buyDate,
			String accountID
			) {
		if (SocketHandle.getDaOutputStream() != null) {
		    SocketHandle.getDaOutputStream().println("request-sell-coin,"+price+","+quantity+","+quantity_curency+","+symbol+","+buyDate+","+accountID);
		} else {
		    System.err.println("Output stream is not ready. Socket may not be initialized yet.");
		}
	}
}