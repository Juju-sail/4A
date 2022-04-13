import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

public class Journal {
	LocalDateTime date;
	PrintWriter writer;
	
	
	public Journal() throws FileNotFoundException, UnsupportedEncodingException {
		super();
		this.writer = new PrintWriter("domotique.log", "UTF-8");
		this.date = LocalDateTime.now();
	}

	public Journal getInstance() {
		return null;
	}
	
	public void ecrire(String str){
		this.writer.println(date);
		this.writer.println(str);
	}
	
	
}
