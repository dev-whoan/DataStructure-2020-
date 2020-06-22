package week09;

import java.util.Scanner;

public class tryMain {
	public static void main(String[] args) {
		System.out.println("201611253 ±ËπŒ»Ø");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		tryHeap heap = new tryHeap();
		
		for(int i = 0; i < n; i ++) {
			int data = in.nextInt();
			if(data == 0) {
				System.out.println(heap.delete());
			}else {
				heap.insert(data);
			}
		}
		in.close();
	}
}
