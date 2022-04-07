public class Test {
	public static void main(String[] args) {
		Boisson b = new Sumatra();
		b = new Lait(b);
		b = new Chocolat(b);
		System.out.println(b.getDescription() + " : " + b.cout());
	}
	
}
