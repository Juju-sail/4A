
public class test {

	public static void main(String[] args) {
		ComportemmentCancan can = new Cancan();
		ComportemmentVol vo = new Voler();
		ComportemmentCancan mute = new Muet();
		ComportemmentVol novo = new NePasVoler();
		
		Colvert c = new Colvert(can, vo);
		Leurre l = new Leurre(mute, novo);
		Prototype p = new Prototype(mute,vo);
		
		c.afficher();
		c.cancaner.cancaner();
		c.voler.voler();
		System.out.println("-------------");
		l.afficher();
		l.cancaner.cancaner();
		l.voler.voler();
		System.out.println("-------------");
		p.afficher();
		p.cancaner.cancaner();
		p.voler.propulsion();

	}

}
