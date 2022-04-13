import java.util.List;

public class TelesurveillanceMaison {
	public List<Commande> commandesMarche;
	public List<Commande> commandesArret;
	
	public TelesurveillanceMaison() {
		super();
		CommandeAlarmeON caon = new CommandeAlarmeON();
		CommandeExtincteurON ceon = new CommandeExtincteurON();
		
		CommandeAlarmeOFF caof = new CommandeAlarmeOFF();
		CommandeExtincteurOFF ceof = new CommandeExtincteurOFF();
		
	}
	
	public void set(int i, Commande comMarche, Commande comArret) {
		this.commandesMarche.set(i, comMarche);
		this.commandesArret.set(i, comArret);
	}
	
	public void appuyerMarche(int i) {
		this.commandesMarche.get(i).exectuer();
	}
	public void appuyerArret(int i) {
		this.commandesArret.get(i).exectuer();
	}
}
