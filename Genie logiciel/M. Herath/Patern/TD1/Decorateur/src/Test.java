public class Test {
	public static void main(String[] args) {
		Boisson b = new Sumatra();
		b = new Lait(b);
		b = new Chocolat(b);
		System.out.println(b.getDescription() + " : " + b.cout());
		
		Boisson b2 = new Sumatra(1);
		b2 = new Chocolat(b2);
		System.out.println(b2.getDescription() + " : " + b2.cout);
	}
	
}
