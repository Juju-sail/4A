import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PremierProgrammeSERVEUR_TCP {
	//Echange entre serveur et client
	  
	public static void main(String[] args) {
		try {
			ServerSocket ecoute = new ServerSocket(1234); // Creation serveur socket sur le sous-port 1234
			while(true) { //indefiniement
				Socket client = ecoute.accept(); // On regarde qui nous parle sur le port et on ouvre de socket pour ce client
				OutputStream os = client.getOutputStream();
				InputStream is = client.getInputStream();
				os.write('s'); // On ecrit notre sortie
				System.out.println(is.read()); //on lit ce qui entre et on l'affiche
				client.close();
			}
		}
		catch(Exception e) {
			//
		}
	}
	
	
	/*Envoie Bonjour! au client
	 
	  public static void main(String[] args) {
		try {
			ServerSocket ecoute = new ServerSocket(1234); // Creation serveur socket sur le sous-port 1234
			String message = "Bonjour!";
	        byte [] tab = message.getBytes();
			while(true) { //indefiniement
				Socket client = ecoute.accept(); // On regarde qui nous parle sur le port et on ouvre de socket pour ce client
				OutputStream os = client.getOutputStream();
				//InputStream is = client.getInputStream();
				//os.write('s'); // On ecrit notre sortie
				for(byte b: tab){
                    os.write(b);
                }
				//System.out.println(is.read()); //on lit ce qui entre et on l'affiche
				client.close();
			}
		}
		catch(Exception e) {
			//
		}
	}
	 */
}
