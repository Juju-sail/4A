import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	
	
	

	@Override
	public String toString() {
		BufferedReader obj;
		String strng;
		String toReturn = "\n";
		try {
			obj = new BufferedReader(new FileReader("domotique.log"));
			while ((strng = obj.readLine()) != null) {
			  toReturn += strng + "\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Journal ["+ toReturn + "]";
	}




	public Journal(PrintWriter writer) {
		super();
		this.writer = writer;
		this.date = LocalDateTime.now();
	}



	public Journal getInstance() {
		Journal j = new Journal(this.writer);
		return j; // avec le toString
	}
	
	public void ecrire(String str){
		this.writer.println(date);
		this.writer.println(str);
	}
	
	
}
