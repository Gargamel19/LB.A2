package trendelenburg.de.liste;

public class TestIt {

	public static void main(String[] args) {
		
		ListenElement list1 = new ListenElement(1, new ListenElement(2, new ListenElement(3, new ListenElement(6, new ListenElement()))));
		ListenElement list1Punkt6 = new ListenElement(6, new ListenElement(6, new ListenElement(6, new ListenElement(6, new ListenElement()))));
		ListenElement list1Punkt2 = new ListenElement(6, new ListenElement(2, new ListenElement(3, new ListenElement(6, new ListenElement()))));
		ListenElement list2 = new ListenElement(2, new ListenElement(5, new ListenElement(6, new ListenElement(7, new ListenElement()))));
		
		ListenElement listInList = new ListenElement(new ListenElement(2, new ListenElement(new ListenElement(2, new ListenElement(5, new ListenElement(6, new ListenElement(7, new ListenElement())))), new ListenElement(6, new ListenElement(7, new ListenElement())))), new ListenElement(2, new ListenElement(3, new ListenElement())));
		ListenElement leiListListInList = new ListenElement(2, new ListenElement(new ListenElement(2, new ListenElement(5, new ListenElement(6, new ListenElement(7, new ListenElement())))), new ListenElement(6, new ListenElement(7, new ListenElement()))));
		
		List listUtil = new List();
		
		System.out.println(list1 + " umgedreht ist: " + listUtil.reverse(list1));
		
		ListenElement le = new ListenElement("nö!", new ListenElement());
		
		System.out.println(le.isNextEmpty());

		le.add(new ListenElement("hallo", new ListenElement()));
		
		System.out.println(le);
		
		
		

		System.out.println(list1.equals(list1));
		
		System.out.println("ist: " + list1 + " eine Liste? " + listUtil.is_a_list(list1));
		System.out.println("ist: " + list2 + " eine Liste? " + listUtil.is_a_list(list2));
		System.out.println("");
		System.out.println("die diffListe von: " + list1 + " und " + list2 + ": " + listUtil.diffList(list1, list2));
		System.out.println("die diffListe von: " + list1 + " und " + new ListenElement(6, new ListenElement()) + ": " + listUtil.diffList(list1, new ListenElement(6, new ListenElement())));
		System.out.println("die diffListe von: " + list2 + " und " + list1 + ": " + listUtil.diffList(list2, list1));
		System.out.println("");
		System.out.println("praefix");
		System.out.println(listUtil.praefix(new ListenElement(1, new ListenElement(2, null)), list1));
		System.out.println(listUtil.praefix(list1, list2));
		System.out.println(listUtil.praefix(list2, list2));
		System.out.println(listUtil.praefix(new ListenElement(), list2));
		System.out.println("");
		System.out.println("infix");
		System.out.println(listUtil.infix(new ListenElement(1, new ListenElement(2, new ListenElement())), list1));
		System.out.println(listUtil.infix(new ListenElement(2, new ListenElement(3, new ListenElement())), list1));
		System.out.println(listUtil.infix(new ListenElement(3, new ListenElement(6, new ListenElement())), list1));
		System.out.println(listUtil.infix(list1, list2));
		System.out.println(listUtil.infix(list2, list2));
		System.out.println(listUtil.infix(new ListenElement(), list2));
		System.out.println("");
		System.out.println("suffix");
		System.out.println(listUtil.suffix(new ListenElement(6, new ListenElement(7, new ListenElement())), list2));
		System.out.println(listUtil.suffix(list1, list2));
		System.out.println(listUtil.suffix(list2, list2));
		System.out.println(listUtil.suffix(new ListenElement(), list2));
		System.out.println("");
		System.out.println("Die länge von: " + list1 + " ist: " + listUtil.length(list1));
		System.out.println("");
		System.out.println("Die Liste: " + listInList + " hat " + listUtil.eo_count(listInList) + " Listen");
		System.out.println("Die Liste: " + leiListListInList + " hat " + listUtil.eo_count(leiListListInList) + " Listen");
		System.out.println("Die Liste: " + list1Punkt6 + " hat " + listUtil.eo_count(list1Punkt6) + " Listen");
		System.out.println("Die Liste: " + new ListenElement() + " hat: " + listUtil.eo_count(new ListenElement()) + " Listen.");
		System.out.println();
		
		System.out.println("delete first: " + new ListenElement(6, new ListenElement()) + " from: " + list1Punkt2 + " = " + listUtil.del_element("e", new ListenElement(6, new ListenElement()), list1Punkt2));
		System.out.println("delete last : " + new ListenElement(6, new ListenElement()) + " from: " + list1Punkt2 + " = " + listUtil.del_element("l", new ListenElement(6, new ListenElement()), list1Punkt2));
		
		System.out.println("delete: " + leiListListInList + " from: " + listInList + " = " + listUtil.del_element("e", leiListListInList, listInList));
		System.out.println("delete: " + new ListenElement(2, new ListenElement()) + " from: " + listInList + " = " + listUtil.del_element("e", new ListenElement(2, new ListenElement()), listInList));
		System.out.println();
		System.out.println("replace first: " + new ListenElement(6, new ListenElement()) + " durch " + new ListenElement(3, new ListenElement()) + " from: " + list1Punkt2 + " = " + listUtil.substitute("e", new ListenElement(6, new ListenElement()), new ListenElement(3, new ListenElement()), list1Punkt2));
		System.out.println("replace last : " + new ListenElement(6, new ListenElement()) + " durch " + new ListenElement(3, new ListenElement()) + " from: " + list1Punkt2 + " = " + listUtil.substitute("l", new ListenElement(6, new ListenElement()), new ListenElement(3, new ListenElement()), list1Punkt2));
		
		System.out.println("replace: " + leiListListInList + " durch " + new ListenElement(3, new ListenElement()) + " from: " + listInList + " = " + listUtil.substitute("e", leiListListInList, new ListenElement(3, new ListenElement()), listInList));
		System.out.println("replace: " + new ListenElement(2, new ListenElement()) + " durch " + new ListenElement(3, new ListenElement()) + " from: " + listInList + " = " + listUtil.substitute("e", new ListenElement(2, new ListenElement()), new ListenElement(3, new ListenElement()), listInList));
		
	}

}
