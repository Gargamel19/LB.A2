package trendelenburg.de.nat;

public class S {

	private S next;
	
	public S() {
	}

	public S getNext() {
		return next;
	}
	
	public void setNext() {
		this.next = new S();
	}
	public void setNext(S next) {
		this.next = next;
	}
	
	public boolean isLast() {
		return (next==null);
	}
	
	public boolean isNull() {
		return next==null;
	}
	
	
	@Override
	public String toString() {
		if(isNull()){
			return "0";
		}else {
			return "S(" + next.toString() + ")";
		}
	}
	
}
