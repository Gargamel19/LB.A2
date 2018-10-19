package trendelenburg.de.nat;

public class test {

	public static void main(String[] args) {
		Snat snat = new Snat();
		S s = new S();
		s.setNext();
		s.getNext().setNext();
		s.getNext().getNext().setNext();
		s.getNext().getNext().getNext().setNext();
		System.out.println(snat.s2nat(s));
		System.out.println(snat.nat2s(6).toString());
		System.out.println(snat.nat2s(1).toString());
		System.out.println(snat.nat2s(0).toString());
	}
	
}
