
public class main {
	public static void main(String[] args) {
		Fille lucie = new Fille("Lucie");
		lucie.compter();
		System.out.println(lucie.getPrenom());
		System.out.println("_______");
		Pere papounet = new Pere("Dupond");
		Fils adrien = new Fils(papounet,"Adrien");
		System.out.println(adrien.getPrenom());
		System.out.println(adrien.getNom());
		Pere papouu = new Pere("Durand");
		adrien.setPapa(papouu);
		System.out.println(adrien.getNom());
	}
}
