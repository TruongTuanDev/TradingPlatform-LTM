package controller;

import socket.SocketHandle;

public class AuthController {
	public static void register(String passWord, String email,String userName) {
		String s1 = passWord;
		String s2 = utils.Encription.encryption(s1);
		SocketHandle.getDaOutputStream().println("request-register,"+s2+","+email+","+","+userName);
	}

}
