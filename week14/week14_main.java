package week14;

import java.util.ArrayList;

public class week14_main {
	public static void main(String[] args) {
		IntComparator ic = new IntComparator();
		MyMergeSort ms = new MyMergeSort(ic);
		ArrayList<Integer> l = new ArrayList<>();
		ArrayList<String> l2 = new ArrayList<>();
		l.add(2);
		l.add(8);
		l.add(9);
		l.add(71);
		l.add(4);
		l.add(1);
		l.add(6);
		l.add(5);
		l.add(3);
		l.add(10);
		ms.sort(l);
		printArr(l);
		StrComparator sc = new StrComparator();
		ms.setComparator(sc);
		l2.add("o");
		l2.add("b");
		l2.add("w");
		l2.add("v");
		l2.add("j");
		l2.add("a");
		l2.add("h");
		l2.add("j");
		l2.add("c");
		l2.add("z");
				
		ms.sort(l2);
		printArr(l2);
	}
	
	public static void printArr(ArrayList arr) {
		for(int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
	}

}
