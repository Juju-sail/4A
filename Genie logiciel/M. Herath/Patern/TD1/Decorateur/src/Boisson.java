
public class Boisson {
	public String description;
	public double cout;
	public Ingredients i;
	public int taille = 2;
	
	public String getDescription() {
		return this.description + this.getTaille();
	}
	public double cout() {
		return this.cout;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
}
