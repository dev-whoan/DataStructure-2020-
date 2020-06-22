package week03;

public class BinaryRecursion {
	public int binarySum(int[] a, int i, int n) {
		if(n == 1) return a[i];
		else return binarySum(a, i, (int)Math.ceil((double)n/2)) + binarySum(a, i + (int)Math.ceil((double)n/2), n/2);
	}
	
	public static void main(String[] args) {
		BinaryRecursion bs = new BinaryRecursion();
		
		int[] arr = new int[100];
		
		for(int i = 0; i < 100; i ++)
		{
			arr[i] = i + 1;
		}
		
		System.out.println("----Binary recursion Test----");
		System.out.println("BinarySum : " + bs.binarySum(arr,  0,  100));
		System.out.println();
	}
	
}
