package Problem_1500;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int K = sc.nextInt();
		
		long[] arr = new long[K];
		long a = S / K;
		long b = S % K;
		
		for(int i = 0; i < K; i++)arr[i]+=a;
		for(int i = 0; i < b; i++)arr[i]++;
		
		long answer = 1;
		for(int i = 0; i<K; i++) answer*=arr[i];
		
		System.out.println(answer);
	}
}
