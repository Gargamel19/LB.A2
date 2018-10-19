package trendelenburg.de.nat;

public class Snat {
	
	int temp;
	S s;
	S tempS;
	
	public int s2nat(S input) {
		temp = 0;
		s2nat_(input);
		return temp;
	}
	private void s2nat_(S input) {
		if (input.isLast()) {
			temp++;
		}else {
			temp++;
			s2nat_(input.getNext());
		}
	}
	
	public S nat2s(int input) {
		if (input == 0) {
			return new S();
		}
		s = new S();
		tempS = s;
		nat2s_(input);
		return s;
	}
	private void nat2s_(int input) {
		if (input==1) {
			tempS.setNext();
		}else {
			tempS.setNext();
			tempS=tempS.getNext();
			nat2s_(input-1);
			
		}
	}
}
