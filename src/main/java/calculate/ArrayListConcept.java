package calculate;

import java.util.ArrayList;

public class ArrayListConcept {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList();
		al.add("I");
		al.add("N");
		al.add("D");
		al.add("I");
		al.add("A");
		al.add(2,"R");
	
		System.out.println(al+ " " +al.size());
		al.remove("D");
		System.out.println(al+ " " +al.size());		

	}

}
