package trendelenburg.de.liste;

public class EoReturn {
	
	int even = 0;
	int odd = 0;
	
	public EoReturn() {
	}
	
	public int getEven() {
		return even;
	}
	public int getOdd() {
		return odd;
	}
	public void setEven(int even) {
		this.even = even;
	}
	
	public void setOdd(int odd) {
		this.odd = odd;
	}
	
	public void addEven() {
		even++;
	}
	
	public void addOdd() {
		odd++;
	}
	
	@Override
	public String toString() {
		return "Gerade: " + even + ", Ungerade: " + odd;
	}
}
