
public class CommandeExtincteurOFF implements Commande{
	public ExtincteurAuto ext = new ExtincteurAuto();
	@Override
	public void exectuer() {
		// TODO Auto-generated method stub
		ext.fermer();
	}

}
