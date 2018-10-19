package trendelenburg.de.nat;

public class S {

	S next;
	boolean isNull = true;
	
	public S() {
		
	}
	
	public S getNext() {
		return next;
	}
	
	public void setNext() {
		this.isNull = false;
		this.next = new S();
	}
	
	public boolean isLast() {
		return (next==null);
	}
	
	@Override
	public String toString() {
		if(isNull){
			return "0";
		}else {
			return "S(" + next.toString() + ")";
		}
		
	}
	
}
