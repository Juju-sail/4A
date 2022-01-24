package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Partie extends Thread{
	// Attributs
	String[][] plateau = new String[9][9];
	BufferedReader in1;
	PrintWriter out1;
	BufferedReader in2;
	PrintWriter out2;
	
	//constructeur(s)
	public Partie(Socket client1, Socket client2) {
		try {
			in1 = new BufferedReader(new InputStreamReader(client1.getInputStream()));
			out1 = new PrintWriter(client1.getOutputStream(), true);
			
			in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
			out2 = new PrintWriter(client2.getOutputStream(), true);
			
		}catch (Exception e) {}
	}
	



	//Affichage de plateau de jeu lors de l'appel
	public String toString() {
		String toReturn = "Partie [plateau= \n";
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				toReturn += plateau[i][j];
				toReturn += " ";
			}
			toReturn +="\n";
		}
		toReturn += "]";
		return toReturn;
	}


	// plateau de jeu vierge
	public void structure() {
		plateau[0][1] = " 1  ";
		plateau[0][2] = " 2  ";
		plateau[0][3] = " 3  ";
		plateau[0][4] = " 4  ";
		plateau[0][5] = " 5  ";
		plateau[0][6] = " 6  ";
		plateau[0][7] = " 7  ";
		plateau[0][8] = " 8  ";
		plateau[1][0] = " 1  ";
		plateau[2][0] = " 2  ";
		plateau[3][0] = " 3  ";
		plateau[4][0] = " 4  ";
		plateau[5][0] = " 5  ";
		plateau[6][0] = " 6  ";
		plateau[7][0] = " 7  ";
		plateau[8][0] = " 8  ";
	}

	// Attaque d'un plateau
	// Pour J2
	public boolean attaque() throws IOException {
		int tir = Integer.valueOf(in2.readLine());
		// Verrification emplacements contient bateau :
		// null = vide 
		// boat = bateau
		// bim! = touché
		// rien = à l'eau
		int haut = tir%10; 
		int gauche = tir/10;
		if(this.plateau[gauche][haut]=="boat") {
			out2.println("touché !");
			this.plateau[gauche][haut] = "bim!";
			return true;
		}
		else if(this.plateau[gauche][haut] == null) {
			out2.println("à l'eau !");
			//Transformer null en rien :
			this.plateau[gauche][haut] = "rien";
			return false;
		}
		else {
			out2.println("erreur");
			return false;
		}
	}

	// Placer bateaux sur plateau
	// Pour J1
	public void placerVosBateaux() throws IOException {
		out1.println("Indiquez les cases utilisées pour vos bateaux (exemple : 11;12;13;54;64;...)"); // envoie indications de jeu à J1
		String boat = in1.readLine(); // recupère les bateaux de J1
		// Boucle de plaçage des bateaux sur le plateau :
		int nbCaseUtilisees = boat.length();
		for(int i=0;i<nbCaseUtilisees/3;i++) {
			String care = boat.split(";")[i];
			int careGauche = Integer.valueOf(care.substring(0, 1));
			int careHaut = Integer.valueOf(care.substring(1, 2));
			this.plateau[careGauche][careHaut] = "boat";
		}
	}

	//Condition de fin de jeu
	public boolean resteBateaux() {
		for(int i = 1 ; i<9;i++){
			for(int j=1; j<9; j++) {
				if("boat"==this.plateau[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

	// Deroulé d'une partie (unique méthode à appeler)
	public void run() {
		System.out.println("Voici le plateau de jeu :");
		this.structure();
		try {
			System.out.println(this);
			this.placerVosBateaux(); //J1 place ses bateaux
			System.out.println(this);
			out2.println("Visez...");
			while(this.resteBateaux()) {
				System.out.println("J2 vise...");
				this.attaque(); // J2 enchaine les attaques
				System.out.println(this);
			}
			out2.println("C'est gagné !"); // J2 gagne
		}
		catch(Exception e){
			
		}
		
	}
}
