package trendelenburg.de.nat;

public class Snat {
	
	public int s2nat(S input) {
		int temp = 0;
		return s2nat_(input, temp);
	}
	private int s2nat_(S input, int temp) {
		// 1. 
		if (input.isNull) {
			return temp++;
		// 2.
		}else {
			temp++;
			return s2nat_(input.getNext(), temp);
		}
	}
	
	public S nat2s(int input) {
		if (input == 0) {
			return new S();
		}
		S s = new S();
		S tempS = s;
		nat2s_(input, tempS);
		return s;
	}
	private void nat2s_(int input, S tempS) {
		// 1. 
		if (input==1) {
			tempS.setNext();
		// 2. 
		}else {
			tempS.setNext();
			tempS=tempS.getNext();
			nat2s_(input-1, tempS);
			
		}
	}
	
	public S add(S s1, S s2) {
		if (s1.isNull) {
			return s2;
		}else if (s2.isNull){
			return s1;
		}
		S ergebniss = new S();
		S tempErg = ergebniss;
		add_(s1, s2, tempErg);
		//3.
		return ergebniss;
	}
	private void add_(S s1, S s2, S ergebnisS) {
		// 1.
		if (!s1.isNull) {
			ergebnisS.setNext();
			add_(s1.getNext(), s2, ergebnisS.getNext());
		// 2.
		}else if (!s2.isNull){
			ergebnisS.setNext();
			add_(s1, s2.getNext(), ergebnisS.getNext());
		}
	}
	
	public S sub(S s1, S s2) {
		if (s2.isNull){
			return s1;
		}
		// 1.
		return sub_(s2, s1);
	}
	
	private S sub_(S s2, S ergebnissS) {
		
		// 2. 
		if (!s2.isNull && !ergebnissS.isNull){
			// 2.a
			ergebnissS = ergebnissS.getNext();
			return sub_(s2.getNext(), ergebnissS);
		// 3.
		}else {
			return ergebnissS;
		}
	}
	
	public S mul(S s1, S s2) {
		// 1.
		return mul_(s1, s2, new S());
	}
	private S mul_(S s1, S s2, S ergebnissS) {
		// 2.a
		if (!s1.isNull && !s2.isNull){
			ergebnissS = add(ergebnissS, s1);
			return mul_(s1, s2.getNext(), ergebnissS);
		}else {
			// 1. & 2.b 
			return ergebnissS;
		}
	}
	
	public S power(S s1, S s2) {
		S s = new S();
		s.setNext();
		// 1. 
		return power_(s1, s2, s);
	}
	private S power_(S s1, S s2, S ergebnissS) {
		// 2.a
		if (!s1.isNull && !s2.isNull){
			ergebnissS = mul(ergebnissS, s1);
			return power_(s1, s2.getNext(), ergebnissS);
		}else {
			// 1. & 2.b 
			return ergebnissS;
		}
	}
	
	public S fac(S s1) {
		S s = new S();
		s.setNext();
		// 1.
		return fac_(s1, s);
	}
	private S fac_(S s1, S ergebnissS) {
		// 2.
		if (!s1.isNull){
			// 2.a
			ergebnissS = mul(ergebnissS, s1);
			return fac_(s1.getNext(), ergebnissS);
		}else {
			// 1 & 2.b
			return ergebnissS;
		}
	}
	
	public boolean lt(S s1, S s2) {
		return lt_(s1, s2);
	}
	private boolean lt_(S s1, S s2) {
		// 1.b
		if (s2.isNull){
			// 1.b.ii
			return false;
		}else if (s1.isNull && !s2.isNull){
			// 1.b.i
			return true;
		}else {
			// 1.a
			return lt_(s1.getNext(), s2.getNext());
		}
	}
	
	public S mods(S s1, S s2) {
		return mods_(s1, s2);
	}
	private S mods_(S s1, S s2) {
		// 1.
		if (lt(s1, s2)){
			// 1.a
			return s1;
		}else {
			// 1.b
			return mods_(sub(s1, s2), s2);
		}
	}
	
}






