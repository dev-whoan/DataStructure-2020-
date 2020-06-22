package week01;

import java.util.Scanner;

public class inputoutput {
	public static void main(String[] args) {
		System.out.println("Type 2 numbers to add:");
		
		int n1, n2;
		
		try (Scanner sIn = new Scanner(System.in)) {
			n1 = sIn.nextInt();
			n2 = sIn.nextInt();

			System.out.println("The result is: " + (n1 + n2));
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println("Done!");
	}
}
