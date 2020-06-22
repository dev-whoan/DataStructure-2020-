package week01;

public class Practice01 {
	
	private static int pow(int n, int x) {
		int result = 1;;
		
		for(int i = 0; i < n; i ++)
			result *= x;
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(pow(5, 2));
		System.out.println(pow(2, 3));
	}
}
