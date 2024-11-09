package controller;

import socket.SocketHandle;

public class MarketController {
	public static void getListCoin() {	
		SocketHandle.getDaOutputStream().println("request-getlistcoin,");
	}
	

}
