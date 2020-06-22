package week15;

import java.util.ArrayList;

public class week15_main {
	public static void main(String[] args) {
		
		Graph g = new Graph(4);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		g.DFS(2);
		System.out.println();
		g.DFS();
		System.out.println();
		
		Graph2 g2 = new Graph2(4);
		g2.addEdge(0, 1);
		g2.addEdge(0, 2);
		g2.addEdge(1, 2);
		g2.addEdge(2, 0);
		g2.addEdge(2, 3);
		g2.addEdge(3, 3);
		
		g2.BFS(2);
		/*
		IntComparator ic = new IntComparator();
		MyMergeSort ms = new MyMergeSort(ic);
		ArrayList<Integer> l = new ArrayList<>();
		ArrayList<String> l2 = new ArrayList<>();
		for(int i = 0; i < 20; i++) {
			l.add((int) (Math.random()*100));
		}
		System.out.println("****난수  1~100 정렬 전****");
		printArr(l);
		ms.sort(l);
		System.out.println("****난수  1~100 정렬 후****");
		printArr(l);
		
		StrComparator sc = new StrComparator();
		ms.setComparator(sc);
		
		String data = "In computer science, a data structure is a data organization, management, and storage format that enables efficient access and modification. More precisely, a data structure is a collection of data values, the relationships among them, and the functinos or operations that can be applied to the data.";

		String[] dataSplits = data.split(" ");
		
		for(int i = 0; i < dataSplits.length; i++) {
			l2.add(dataSplits[i]);
		}
		System.out.println("****Text 정렬 전****");
		printArr(l2);
		ms.sort(l2);
		System.out.println("****Text 정렬 후****");
		printArr(l2);
		*/
	}
	
	public static void printArr(ArrayList arr) {
		for(int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
	}

}
