package Problem_2163;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// tot = N-1 + N(M-1) == MN -1
		System.out.println(M*N - 1);
		
		

		
	}
}
