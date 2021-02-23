package Problem_2502;

import java.util.Scanner;

public class Main {
	static long[] A = new long[31];
	static long[] B = new long[31];
	static int i,j;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();
		int K = sc.nextInt();
		A[1] = 1; B[2] = 1;
		
		A[3] = B[3] = 1;
		for(int i = 4; i<=D; i++) {
			A[i] = B[i-1];
			B[i] = A[i-1] + B[i-1];
		}
		
		for(i = 1; i<K; i++) {
			for(j = i; j<K; j++) {
				if(i*A[D] + j*B[D] == K) {
					if(i < j) {						
						System.out.println(i + "\n" + j);
						return;
					}
				}
			}
		}
	}

}
