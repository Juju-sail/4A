
public abstract class DetectMvt {
	public Commande com;
	
	public void alerter() {
		Sms mess = new Sms();
		mess.envoyerMessage("Mouvement detecter");
		
	}
}
