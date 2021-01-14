package Problem_2407;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static int N, K;
	static BigInteger[][] arr;
	static BigInteger solution(int N, int K) {
		if(N == K) return BigInteger.ONE;
		if(K == 0) return BigInteger.ONE;
		if(arr[N][K] != null) return arr[N][K];
		return arr[N][K] = new BigInteger(solution(N-1,K).add(solution(N-1,K-1)).toString());
	}
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); K = sc.nextInt();
		arr = new BigInteger[N+1][K+1];
		System.out.println(solution(N,K));
		
	}
}