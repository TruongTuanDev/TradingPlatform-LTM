package controller;

import socket.SocketHandle;

public class AuthController {
	public static void register(String passWord, String email,String userName) {
		String s1 = passWord;
//		String s2 = utils.Encription.encryption(s1);
		if (SocketHandle.getDaOutputStream() != null) {
		    SocketHandle.getDaOutputStream().println("request-register,"+s1+","+email+","+userName);
		} else {
		    System.err.println("Output stream is not ready. Socket may not be initialized yet.");
		}
	}

}
