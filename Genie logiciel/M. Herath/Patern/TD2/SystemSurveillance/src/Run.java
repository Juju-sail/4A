import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Run {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Journal j = new Journal();
		j.ecrire("ma chaine");
		j.ecrire("ma chaine 2");
		j.ecrire("ma chaine 3");
		j.ecrire("ma chaine 4");
		j.writer.close();
		
		CommandeAlarmeON caon = new CommandeAlarmeON();
		caon.exectuer();
		CommandeAlarmeOFF caof = new CommandeAlarmeOFF();
		caof.exectuer();
		CommandeExtincteurON ceon = new CommandeExtincteurON();
		ceon.exectuer();
		CommandeExtincteurOFF ceof = new CommandeExtincteurOFF();
		ceof.exectuer();
	}
}
