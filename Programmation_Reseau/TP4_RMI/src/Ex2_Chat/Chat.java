package Ex2_Chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Chat extends Remote{
	void sendMessage(String message) throws RemoteException; // peut-�tre un string pour plus de facilit�s, � voir
	String recepMessage(int position) throws RemoteException;
	int recupNBmessages() throws RemoteException;
	String userArrived(String nom) throws RemoteException;
	String userQuit(String nom) throws RemoteException;
}
