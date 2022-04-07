
public class Chocolat extends Ingredients{
	public Boisson boisson;

	public Chocolat(Boisson boisson) {
		super();
		this.boisson = boisson;
		this.cout = boisson.cout();
		this.description = boisson.getDescription();
	}
	
	public double cout() {
		return this.cout + 0.45;
	}
	public String getDescription() {
		return this.description + " avec du Chocolat";
	}
	
}
