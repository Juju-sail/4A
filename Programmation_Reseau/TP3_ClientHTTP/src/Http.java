import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Http {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("vdespre.free.fr/TPHTTP.php", 80);
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			String message="GET /TPHTTP.php HTTP/1.1\r\n host: vdespre.free.fr\r\n\r\n";
			out.println(message);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String recep = in.readLine();
			while(recep != null) {
				System.out.println(recep);
				recep = in.readLine();
			}
			s.close();
			} catch(Exception e) {
			// Traitement d'erreur
			}

	}
}
