
public class Fils {
	public Pere papa;
	public String prenom;
	
	public String getPrenom() {
		return prenom;
	}
	
	
	
	public Fils(Pere papa, String prenom) {
		super();
		this.papa = papa;
		this.prenom = prenom;
	}



	public void setPapa(Pere papa) {
		this.papa = papa;
	}
	
	public String getNom() {
		return this.papa.getNom();
	}
	
}
