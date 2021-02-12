package Problem_16395;

import java.util.Scanner;

public class Main {
	static int[][] arr = new int[31][31];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(answer(N-1, K-1));
	}
	
	static int answer(int N, int K) {
		if(arr[N][K] > 0) return arr[N][K];
		if(K == 0 || K == N) return arr[N][K] = 1;
		return arr[N][K] = answer(N-1, K-1) + answer(N-1, K); 
	}
}
