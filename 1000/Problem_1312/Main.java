package Problem_1312;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int N = sc.nextInt();
		int answer = 0;
		if(A >= B) A%=B;
		
		for(int i = 0; i<N; i++) {
			A*=10;
			answer = A/B;
			A = A%B;
		}	
		System.out.println(answer);
	}
}