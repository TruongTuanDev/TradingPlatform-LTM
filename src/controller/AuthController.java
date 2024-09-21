package controller;

import socket.SocketHandle;

public class AuthController {
	public static void register(String userName,String passWord, String email) {
		String s1 = passWord;
//		String s2 = utils.Encription.encryption(s1);
		System.out.println(passWord+email);
		SocketHandle.getDaOutputStream().println("request-register,"+userName+","+s1+","+email);
	}
	public static void login(String userName,String passWord) {
//		String s1 = passWord;
//		String s2 = utils.Encription.encryption(s1);
		if (SocketHandle.getDaOutputStream() != null) {
		    SocketHandle.getDaOutputStream().println("request-login,"+userName+","+passWord);
		} else {
		    System.err.println("Output stream is not ready. Socket may not be initialized yet.");
		}
	}

}
