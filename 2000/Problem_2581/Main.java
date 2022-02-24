package Problem_2581;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static boolean[] arr = new boolean[10001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		Arrays.fill(arr, true);
		arr[1] = false;
		arr[0] = false;
		
		for(int i = 2; i<=10000;i++) {
			if(arr[i]) {
				for(int j = i*2; j<=10000;j+=i) {
					arr[j] = false;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int a = M; a <= N; a++) {
			if(arr[a]) {
				sum += a;
				if(min > a) min = a;
			}
		}
		if(min == Integer.MAX_VALUE) { System.out.println(-1); }
		else {
			System.out.println(sum);
			System.out.println(min);	
		}
	}
}
