package Problem_11051;

import java.util.Scanner;

public class Main {
	static int[][] arr = new int[1001][1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(getAnswer(N,K));
	}
	
	public static int getAnswer(int N, int K) {
		if(K == 0 || N == K) return arr[N][K] = 1;
		if(arr[N][K] > 0) return arr[N][K] % 10007; 
		return arr[N][K] = (getAnswer(N-1,K) + getAnswer(N-1,K-1))% 10007;
	}
}
