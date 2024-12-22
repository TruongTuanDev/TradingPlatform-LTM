package controller;

import socket.SocketHandle;

public class MarketController {
	public static void getQuantityCurency(String userName,String symbol) {
		
		SocketHandle.getDaOutputStream().println("request-quantity_curency,"+userName+","+symbol+",");
	}
	public static void getListCoin() {	
		
		if (SocketHandle.getDaOutputStream() != null) {
		    SocketHandle.getDaOutputStream().println("request-getlistcoin,");
		} else {
		    System.err.println("Output stream is not ready. Socket may not be initialized yet.");
		}
	}
	}

