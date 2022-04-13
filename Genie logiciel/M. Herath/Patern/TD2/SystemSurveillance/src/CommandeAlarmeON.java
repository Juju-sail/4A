
public class CommandeAlarmeON implements Commande{
	public AlarmMvt alarm = new AlarmMvt();
	@Override
	public void exectuer() {
		// TODO Auto-generated method stub
		alarm.demarrer();
	}

}
