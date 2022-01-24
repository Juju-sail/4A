package Ex1_HelloWorld;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements HelloWorld {

	public static void main(String[] args) {
		
        try {
        	Server obj = new Server();
			HelloWorld stub = (HelloWorld) UnicastRemoteObject.exportObject(obj, 0);
			
			LocateRegistry.createRegistry(1099);
			
			Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);

            System.err.println("Server ready");
            
		} catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
		}
	}

	@Override
	public String sayHello() throws RemoteException {
		return "yo";
	}

}
