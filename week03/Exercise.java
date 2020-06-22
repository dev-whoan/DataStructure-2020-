package week03;

import java.util.Scanner;

public class Exercise {
	
	static int factorial(int n) {
		if(n == 0) return 1;
		else return (n*factorial(n-1));
	}
	
	
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		factorial(n);
	}
}


