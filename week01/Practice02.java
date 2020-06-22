package week01;

public class Practice02 {
	public static int[] reverse(int[] list, int n) {
		int[] rlist = new int[n];
		
		for(int i = 0; i < n; i++)
			rlist[i] = list[n-i-1];
		
		return rlist;
	}
	
	public static void main(String[] args) {
		int list[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int rl[] = reverse(list, 9);
		
		for(int i = 0; i < rl.length; i++)
			System.out.print(rl[i] + " ");
	}
}
