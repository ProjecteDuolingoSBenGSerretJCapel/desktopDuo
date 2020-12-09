package desktopDuo.server;

import java.util.ArrayList;

import libDuo.model.Curs;
import lipermi.handler.CallHandler;
import lipermi.net.Server;



public class ServidorDesktopDuo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ServidorDesktopDuo();

	}
	
	public ServidorDesktopDuo() {
		try {
			CallHandler callHandler = new CallHandler();
			
			IServerRMI iServerImplements = new ServerDesktopDuoImplements();
			
			callHandler.registerGlobal(IServerRMI.class, iServerImplements);
			
			Server server = new Server();
			int port = 15015;
			server.bind(port, callHandler);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}



}
