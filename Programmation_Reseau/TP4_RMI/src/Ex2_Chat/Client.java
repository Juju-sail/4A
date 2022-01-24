package Ex2_Chat;

import java.io.PrintWriter;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
	private Client() {} //constructeur
	
	public static void main(String[] args) {
		String host = (args.length < 1) ? null : args[0];
		
		try {
			Registry registry = LocateRegistry.getRegistry(host);
            Chat stub = (Chat) registry.lookup("Parle");

            new PollThread(stub).start();
            
            System.out.println("Entrez votre nom : ");
            Scanner nom = new Scanner(System.in);
            String nomClient = nom.nextLine();
            
            stub.sendMessage(stub.userArrived(nomClient));
            
            int nbechanges = 0;
            
            while(stub.recepMessage(nbechanges) != "quit") {
            	//System.out.println(stub.recepMessage(nbechanges));
            	
            	Scanner mess = new Scanner(System.in);
                String mes = mess.nextLine();
                
            	stub.sendMessage(nomClient + " : " + mes);
            	nbechanges ++;
            }
            System.out.println(stub.userQuit(nomClient));
            System.out.println(stub.recupNBmessages());
            
            
		} catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
		}
        
        
		
	}
}
