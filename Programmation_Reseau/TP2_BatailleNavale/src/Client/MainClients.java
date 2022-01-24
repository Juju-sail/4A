package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import Server.Partie;

public class MainClients {
	
	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 1500);
			PrintWriter out= new PrintWriter(s.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			Scanner console = new Scanner(System.in);
			while (true) {
				//afficher ce qui arrive 
				System.out.println(in.readLine());
				//envoyer ce que je veux
				out.println(console.nextLine());
			}
		} catch(Exception e) {
			// Traitement d'erreur
		}

	}
}