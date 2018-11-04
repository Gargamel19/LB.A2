package trendelenburg.de.liste;

public class ListenElement {

	private Object data;
	private ListenElement next;

	public ListenElement() {
	}


	public ListenElement(Object data, ListenElement next) {
		this.data = data;
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public boolean isNextEmpty() {
		return next == null;
	}

	public ListenElement getNext() {
		return next;
	}

	public void setNext(Object data) {
		next = new ListenElement();
	}

	public boolean contains(Object element) {
		if (isNextEmpty()) {
			return false;
		} else {
			if (element.equals(getData())) {
				return true;
			} else {
				return getNext().contains(element);
			}
		}
		
	}

	public void add(Object other) {
		if (isNextEmpty()) {
			data = other;
			next = new ListenElement();
		} else {
			next.add(other);
		}

	}

	public boolean is_a_list() {
		if (next == null) {
			return true;
		} else {
			return next.is_a_list();
		}
	}

	@Override
	public boolean equals(Object otherData) {
		if (otherData instanceof ListenElement) {
			ListenElement le = (ListenElement) otherData;
			if (getData()==null && le.getData()==null) {
				return true;
			} else {
				if (data.equals(le.getData())) {
					if (getNext().isNextEmpty() && le.getNext().isNextEmpty()) {

						return true;

					} else {
						return getNext().equals(le.getNext());
					}
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "[" + toString_();
	}

	public String toString_() {
		if (isNextEmpty()) {
			return "]";
		} else {
			if (getNext().isNextEmpty()) {
				return data + "]";
			} else {

			}
			return data + ", " + next.toString_();
		}
	}

}
