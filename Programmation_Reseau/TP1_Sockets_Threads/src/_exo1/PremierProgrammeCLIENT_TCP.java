import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PremierProgrammeCLIENT_TCP {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1",1234);
			OutputStream os = s.getOutputStream();
			InputStream is = s.getInputStream();
			os.write('c');
			System.out.println(is.read());
			s.close();
		}
		catch(Exception e) {
			// Erreurs
		}
	}
	
	/*Recoit Bonjour! de la part du serveur
	 * 
	 * public static void main(String[] args) {
	 *	try {
	 *		Socket s = new Socket("127.0.0.1",1234);
	 *		//OutputStream os = s.getOutputStream();
	 *		InputStream is = s.getInputStream();
	 *		for(int i=0;i<8;i++) { //wile(is.enable) à tester
	 *			// os.write('c');
	 *			System.out.println((char) is.read());
	 *		}
	 *		s.close();
	 *		
	 *	}
	 *	catch(Exception e) {
	 *		// Erreurs
	 *	}
	 * }
	 */
	
	
	
	
	
}
