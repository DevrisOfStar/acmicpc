package Problem_2875;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		// N-2, M-1,
		int answer =0;
		
		
		
		
		while(K > 0) {
			K--;
			if(N >= 2*M) {
				N--;
			}
			else if (N < 2*M) {
				M--;
			}
		}
		if(N < 0 || M < 0) {
			System.out.println("0"); return;
		}
		
		answer = Math.min(N/2, M);
		System.out.println(answer);
	}
}
