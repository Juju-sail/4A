
public class Lait extends Ingredients{
	public Boisson boisson;

	public Lait(Boisson boisson) {
		super();
		this.boisson = boisson;
		this.cout = boisson.cout();
		this.description = boisson.getDescription();
		this.setTaille(boisson.getTaille());
	}
	
	public double cout() {
		return this.cout + 0.3;
	}
	public String getDescription() {
		return this.description + " avec du Lait";
	}
	
}
