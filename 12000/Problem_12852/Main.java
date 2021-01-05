package Problem_12852;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		int[] before = new int[N+1];
		arr[1] = 0;
		before[1] = -1;
		
		for(int i = 2; i<=N;i++) {
			arr[i] = arr[i-1] + 1;
			before[i] = i-1;
			
			if(i%2 == 0 && arr[i] > arr[i/2] + 1) {
				arr[i] = arr[i/2] + 1;
				before[i] = i/2;
			}
			if(i%3 == 0 && arr[i] > arr[i/3] + 1) {
				arr[i] = arr[i/3] + 1;
				before[i] = i/3;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(arr[N]).append("\n");
		while(N != -1) {
			sb.append(N).append(" ");
			N = before[N];
		}
		
		System.out.println(sb.toString());
		
		
	}
}
