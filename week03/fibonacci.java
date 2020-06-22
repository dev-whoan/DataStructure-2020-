package week03;

public class fibonacci {
	
	static long i = 0, j = 1;
	static int idx = 1;
	public static void main(String args[])
	{
		System.out.println("====Binary=====");
		System.out.println(fibonacci(10));
		
		System.out.println("====iterated=====");
		
		int n1 = 0, n2 = 1;
		int n3, i, count = 10;
		
		System.out.print(n1 + " " + n2);
		
		for(i = 2; i <= count; ++i)
		{
			n3 = n1+n2;
			System.out.print(" " + n3);
			n1 = n2;
			n2 = n3;
		}
		
		System.out.println("====Linear=====");
		linearFibo(10);
	}
	
	private static int fibonacci(int n)
	{
		if( n <= 1 ) return n;
		else return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static void linearFibo(int n) {
		if( n <= 1)
			System.out.println("F("+(idx)+") : "+j+", F("+(idx-1)+") : "+i);
		else
		{
			System.out.println("F("+(idx)+") : "+j+", F("+(idx-1)+") : "+i);
			idx++;
			
			long temp = j;
			j = i+j;
			i = temp;
			linearFibo(n-1);
		}
	}
}
