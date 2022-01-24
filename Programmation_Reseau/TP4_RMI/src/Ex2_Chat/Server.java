package Ex2_Chat;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server implements Chat{
	
	public ArrayList<String> tab = new ArrayList<>(); // tab qui recup les messages
	
	public static void main(String[] args) {
		try {
			Server obj = new Server();
			Chat stub = (Chat) UnicastRemoteObject.exportObject(obj, 0);
			
			LocateRegistry.createRegistry(1099);
			
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("Parle", stub);
			
			System.err.println("Server ready");
			
		} catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
		} 
	}


	
	public String userArrived(String nom) throws RemoteException {
		return nom + " est là";
		
	}

	public String userQuit(String nom) throws RemoteException {
		//Condition
		return nom + " est parti";
		
	}
	
	public void sendMessage(String message) throws RemoteException {
		//Scanner toSend = new Scanner(System.in);
		//String message = toSend.nextLine();
		tab.add(message);
	}
	
	public String recepMessage(int position) throws RemoteException {
		return tab.get(position);
	}

	public int recupNBmessages() throws RemoteException {
		return tab.size();
	}

}
