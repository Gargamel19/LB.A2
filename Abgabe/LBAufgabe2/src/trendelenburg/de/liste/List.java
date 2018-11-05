package trendelenburg.de.liste;

public class List {

	public boolean is_a_list(ListenElement liste) {
		// 1. & 2.
		return liste.is_a_list();
	}

	public ListenElement diffList(ListenElement liste1, ListenElement liste2) {
		ListenElement ergebnisListe = new ListenElement();
		return diffList_(liste1, liste2, ergebnisListe);
	}

	private ListenElement diffList_(ListenElement liste1, ListenElement liste2, ListenElement ergebnisListe) {
		if (liste1.getData() == null) {
			return ergebnisListe;
		}
		// 1.
		if (liste1.isNextEmpty()) {
			if (!liste2.contains(liste1.getData())) {
				ergebnisListe.add(liste1.getData());
			}
			return ergebnisListe;
		} else {
			// 2.
			if (liste2.contains(liste1.getData())) {
				// 2.a
				return diffList_(liste1.getNext(), liste2, ergebnisListe);
			} else {

				// 2.b
				ergebnisListe.add(liste1.getData());
				return diffList_(liste1.getNext(), liste2, ergebnisListe);
			}
		}
	}

	public boolean praefix(ListenElement liste1, ListenElement liste2) {
		// 1.
		if (liste1.isNextEmpty() || liste2.isNextEmpty()) {
			return false;
		}
		return praefix_(liste1, liste2);
	}

	private boolean praefix_(ListenElement liste1, ListenElement liste2) {
		if (liste1.isNextEmpty() && !liste2.isNextEmpty()) {
			// 2.b:i
			return true;
		} else if (liste2.isNextEmpty()) {
			return false;
		} else {
			// 2.
			if (liste1.getData().equals(liste2.getData())) {
				// 2.a
				return praefix_(liste1.getNext(), liste2.getNext());
			} else {
				// 2.b:ii
				return false;
			}
		}
	}

	public boolean suffix(ListenElement liste1, ListenElement liste2) {
		if (liste1.isNextEmpty() || liste2.isNextEmpty()) {
			return false;
		}
		// 1. & 2. & 3.
		return praefix(reverse(liste1), reverse(liste2));
	}

	public ListenElement reverse(ListenElement liste1) {
		ListenElement le = new ListenElement();
		return reverse_(liste1, le);
	}

	private ListenElement reverse_(ListenElement liste1, ListenElement returnList) {
		if (liste1.isNextEmpty()) {
			return returnList;
		} else {
			if (returnList.isNextEmpty()) {
				return reverse_(liste1.getNext(), new ListenElement(liste1.getData(), new ListenElement()));
			} else {
				return reverse_(liste1.getNext(), new ListenElement(liste1.getData(), returnList));
			}
		}
	}

	public boolean infix(ListenElement liste1, ListenElement liste2) {
		// 1.
		if (liste2.isNextEmpty()) {
			return false;
		}
		// 2.
		return infix_(liste1, liste2.getNext());
	}

	private boolean infix_(ListenElement liste1, ListenElement liste2) {

		// 3.
		if (liste2.isNextEmpty()) {
			return false;
		}
		// 4.
		if (praefix(liste1, liste2)) {
			return true;
			// 4.b.ii
		} else {
			return infix_(liste1, liste2.getNext());
		}
	}

	public int length(ListenElement liste) {
		int length = length_(liste, 0);
		return length;
	}

	private int length_(ListenElement liste, int length) {
		if (liste.isNextEmpty()) {
			return length;
		} else if (liste.isNextEmpty()) {
			length++;
			return length;
		} else {
			length++;
			return length_(liste.getNext(), length);
		}
	}

	public EoReturn eo_count(ListenElement liste1) {
		EoReturn returnElement = new EoReturn();
		eo_count_(liste1, returnElement);
		if (length(liste1) % 2 == 0) {
			returnElement.addEven();
		} else {
			returnElement.addOdd();
		}
		return returnElement;
	}

	private EoReturn eo_count_(ListenElement liste1, EoReturn eoR) {
		// 1.
		if (liste1.isNextEmpty()) {
			// 1.a
			return eoR;
		}
		// 1.b
		if (liste1.getData() instanceof ListenElement) {
			ListenElement subList = (ListenElement) liste1.getData();
			// 1.b.i
			if ((length(subList) % 2) == 0) {
				// 1.b.i.1
				eoR.addEven();
			} else {
				// 1.b.i.2
				eoR.addOdd();
			}
			// 1.b.i.3
			eo_count_(liste1.getNext(), eoR);
			// 1.b.i.4
			eo_count_(subList.getNext(), eoR);
			return eoR;

		} else {
			// 1.b.ii
			return eo_count_(liste1.getNext(), eoR);
		}

	}

	public ListenElement del_element(String position, ListenElement element, ListenElement liste) {

		// 1.
		if (position == "l") {
			return reverse(del_element_("e", element, reverse(liste), new ListenElement()));
		}
		return del_element_(position, element, liste, new ListenElement());
	}

	private ListenElement del_element_(String position, ListenElement element, ListenElement liste,
			ListenElement returnList) {
		// 5.
		if (liste.isNextEmpty()) {
			return returnList;
		} else {
			if (element.getNext().isNextEmpty()) {

				if (liste.getData().equals(element.getData())) {

					// 3.
					if (position == "a") {
						return del_element_(position, element, liste.getNext(), returnList);

						// 2.
					} else if (position == "e") {
						return del_element_("ende", element, liste.getNext(), returnList);

						// 4.
					} else {
						returnList.add(liste.getData());
						return del_element_(position, element, liste.getNext(), returnList);
					}
					// 4.
				} else {
					returnList.add(liste.getData());
					return del_element_(position, element, liste.getNext(), returnList);
				}
			} else {
				if (liste.getData().equals(element)) {

					// 3.
					if (position == "a") {
						return del_element_(position, element, liste.getNext(), returnList);

						// 2.
					} else if (position == "e") {
						return del_element_("ende", element, liste.getNext(), returnList);

						// 4.
					} else {
						returnList.add(liste.getData());
						return del_element_(position, element, liste.getNext(), returnList);
					}
					// 4.
				} else {
					returnList.add(liste.getData());
					return del_element_(position, element, liste.getNext(), returnList);
				}
			}
		}

	}

	public ListenElement substitute(String position, ListenElement element, ListenElement newElement,
			ListenElement liste) {

		// 1.
		if (position == "l") {
			// 1.a-b
			return reverse(substitute_("e", element, newElement, reverse(liste), new ListenElement()));
		}
		return substitute_(position, element, newElement, liste, new ListenElement());
	}

	private ListenElement substitute_(String position, ListenElement element, ListenElement newElement,
			ListenElement liste, ListenElement returnList) {
		// 5.
		if (liste.isNextEmpty()) {
			return returnList;
		} else {
			if (element.getNext().isNextEmpty()) {

				if (liste.getData().equals(element.getData())) {

					// 3.
					if (position == "a") {
						returnList.add(newElement.getData());
						return substitute_(position, element, newElement, liste.getNext(), returnList);

						// 2.
					} else if (position == "e") {
						returnList.add(newElement.getData());
						return substitute_("ende", element, newElement, liste.getNext(), returnList);

						// 4.
					} else {
						returnList.add(liste.getData());
						return substitute_(position, element, newElement, liste.getNext(), returnList);
					}
					// 4.
				} else {
					returnList.add(liste.getData());
					return substitute_(position, element, newElement, liste.getNext(), returnList);
				}
			} else {
				if (liste.getData().equals(element)) {

					// 3.
					if (position == "a") {
						returnList.add(newElement.getData());
						return substitute_(position, element, newElement, liste.getNext(), returnList);

						// 2.
					} else if (position == "e") {
						returnList.add(newElement.getData());
						return substitute_("ende", element, newElement, liste.getNext(), returnList);

						// 4.
					} else {
						returnList.add(liste.getData());
						return substitute_(position, element, newElement, liste.getNext(), returnList);
					}
					// 4.
				} else {
					returnList.add(liste.getData());
					return substitute_(position, element, newElement, liste.getNext(), returnList);
				}
			}
		}

	}

}
