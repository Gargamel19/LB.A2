package trendelenburg.de.nat;

public class Snat {
	
	public int s2nat(S input) {
		int temp = 0;
		return s2nat_(input, temp);
	}
	private int s2nat_(S input, int temp) {
		if (input.isNull) {
			return temp++;
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
		if (input==1) {
			tempS.setNext();
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
		return ergebniss;
	}
	private void add_(S s1, S s2, S ergebnissS) {
		if (!s1.isNull) {
			ergebnissS.setNext();
			add_(s1.getNext(), s2, ergebnissS.getNext());
		}else if (!s2.isNull){
			ergebnissS.setNext();
			add_(s1, s2.getNext(), ergebnissS.getNext());
		}
		
	}
	
	public S sub(S s1, S s2) {
		if (s2.isNull){
			return s1;
		}
		return sub_(s2, s1);
	}
	
	private S sub_(S s2, S ergebnissS) {
		
		if (!s2.isNull && !ergebnissS.isNull){
			ergebnissS = ergebnissS.getNext();
			return sub_(s2.getNext(), ergebnissS);
		}else {
			return ergebnissS;
		}
	}
	
	public S mul(S s1, S s2) {
		return mul_(s1, s2, new S());
	}
	private S mul_(S s1, S s2, S ergebnissS) {
		if (!s1.isNull && !s2.isNull){
			ergebnissS = add(ergebnissS, s1);
			return mul_(s1, s2.getNext(), ergebnissS);
		}else {
			return ergebnissS;
		}
	}
	
	public S power(S s1, S s2) {
		return power_(s1, s2, new S());
	}
	private S power_(S s1, S s2, S ergebnissS) {
		if (!s1.isNull && !s2.isNull){
			ergebnissS = mul(ergebnissS, s1);
			return power_(s1, s2.getNext(), ergebnissS);
		}else {
			return ergebnissS;
		}
	}
	
}






