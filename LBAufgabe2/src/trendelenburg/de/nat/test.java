package trendelenburg.de.nat;

public class test {

	public static void main(String[] args) {
		Snat snat = new Snat();
		S s = new S();
		s.setNext();
		s.getNext().setNext();
		s.getNext().getNext().setNext();
		s.getNext().getNext().getNext().setNext();
		System.out.println(snat.s2nat(s) + ": " + s.toString());
		System.out.println("6: " + snat.nat2s(6).toString());
		System.out.println("1: " + snat.nat2s(1).toString());
		System.out.println("0: " + snat.nat2s(0).toString());
		
		
		S newS1 = new S();
		newS1.setNext();
		newS1.getNext().setNext();
		S newS2 = new S();
		S erg = new S();
		newS2.setNext();
		newS2.getNext().setNext();
		newS2.getNext().getNext().setNext();
		newS2.getNext().getNext().getNext().setNext();
		newS2.getNext().getNext().getNext().getNext().getNext();
		System.out.println("");
		System.out.println("Plus:");
		System.out.println(newS1.toString());
		System.out.println(newS2.toString());
		System.out.println(snat.add(newS1, newS2).toString());
		System.out.println("");
		System.out.println("Mahl 1:");
		System.out.println(snat.nat2s(6));
		System.out.println(snat.nat2s(1));
		System.out.println(snat.mul(snat.nat2s(6), snat.nat2s(1)).toString());
		System.out.println("");
		System.out.println("Mahl 0:");
		System.out.println(snat.nat2s(6));
		System.out.println(snat.nat2s(0));
		System.out.println(snat.mul(snat.nat2s(6), snat.nat2s(0)).toString());
		System.out.println("");
		System.out.println("Multiplikation 6 * 3:");
		System.out.println(snat.nat2s(6));
		System.out.println(snat.nat2s(3));
		erg = snat.mul(snat.nat2s(6), snat.nat2s(3));
		System.out.println(erg.toString() + " in Zahlen: " + snat.s2nat(erg));
		System.out.println("");
		System.out.println("Substraktion 6 - 4:");
		System.out.println(snat.nat2s(6));
		System.out.println(snat.nat2s(4));
		System.out.println(snat.sub(snat.nat2s(6), snat.nat2s(4)).toString());
		System.out.println("");
		System.out.println("Substraktion 4 - 6:");
		System.out.println(snat.nat2s(4));
		System.out.println(snat.nat2s(6));
		System.out.println(snat.sub(snat.nat2s(4), snat.nat2s(6)).toString());
		System.out.println("");
		System.out.println("Substraktion 6 - 6:");
		System.out.println(snat.nat2s(6));
		System.out.println(snat.nat2s(6));
		System.out.println(snat.sub(snat.nat2s(6), snat.nat2s(6)).toString());
		
		System.out.println("");
		System.out.println("Power 6^4:");
		System.out.println(snat.nat2s(6));
		System.out.println(snat.nat2s(4));
		System.out.println(snat.power(snat.nat2s(6), snat.nat2s(4)).toString());
		System.out.println("");
		System.out.println("Power 4^6:");
		System.out.println(snat.nat2s(4));
		System.out.println(snat.nat2s(6));
		System.out.println(snat.s2nat(snat.power(snat.nat2s(4), snat.nat2s(6))) + ": " + snat.power(snat.nat2s(4), snat.nat2s(6)).toString());
		System.out.println("");
		System.out.println("Power 6^2:");
		System.out.println(snat.nat2s(6));
		System.out.println(snat.nat2s(2));
		System.out.println(snat.s2nat(snat.power(snat.nat2s(6), snat.nat2s(2))) + ": " + snat.power(snat.nat2s(6), snat.nat2s(2)).toString());
		System.out.println("");
		System.out.println("Fac 6:");
		System.out.println(snat.s2nat(snat.fac(snat.nat2s(6))) + ": " + snat.fac(snat.nat2s(6)).toString());
		System.out.println("");
		System.out.println("Fac 0:");
		System.out.println(snat.s2nat(snat.fac(snat.nat2s(0))) + ": " + snat.fac(snat.nat2s(0)).toString());
		System.out.println("");
		System.out.println("Fac 1:");
		System.out.println(snat.s2nat(snat.fac(snat.nat2s(1))) + ": " + snat.fac(snat.nat2s(1)).toString());
		System.out.println("");
		System.out.println("lt:");
		System.out.println(snat.nat2s(6) +" < "+ snat.nat2s(6) + ": " + snat.lt(snat.nat2s(6), snat.nat2s(6)));
		System.out.println("");
		System.out.println(snat.nat2s(6) +" < "+ snat.nat2s(8) + ": " + snat.lt(snat.nat2s(6), snat.nat2s(8)));
		System.out.println("");
		System.out.println(snat.nat2s(8) +" < "+ snat.nat2s(6) + ": " + snat.lt(snat.nat2s(8), snat.nat2s(6)));
		
		System.out.println("");
		System.out.println("modulo 3 % 2:");
		System.out.println(snat.nat2s(3));
		System.out.println(snat.nat2s(2));
		System.out.println(snat.s2nat(snat.mods(snat.nat2s(3), snat.nat2s(2))) + ": " + snat.mods(snat.nat2s(3), snat.nat2s(2)).toString());
		System.out.println("");
		System.out.println("modulo 6 % 2:");
		System.out.println(snat.nat2s(6));
		System.out.println(snat.nat2s(2));
		System.out.println(snat.s2nat(snat.mods(snat.nat2s(6), snat.nat2s(2))) + ": " + snat.mods(snat.nat2s(6), snat.nat2s(2)).toString());
		
	}
	
}
