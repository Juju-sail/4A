package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServers {
	public static void main(String[] args) throws IOException {
		
		ServerSocket ecoute = new ServerSocket(1500);
		System.out.println("Serveur lancé!");
		
		while(true) {
			Socket client1 = ecoute.accept();
			Socket client2 = ecoute.accept();

			Partie p = new Partie(client1,client2); // creation partie entre deux clients
			p.start(); // Lancement du déroulé de la partie et des threads (appel du void run() )
			//p.partie();

		}
	}
}
