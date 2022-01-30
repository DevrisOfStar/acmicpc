package Problem_1475;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();
		int cnt69 = 0;
		int[] arr = new int[10];
		
		for(int i = 0; i<N.length(); i++) {
			if(N.charAt(i) == '6' || N.charAt(i) == '9') cnt69++;
			else arr[N.charAt(i) - '0']++;
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<10; i++) {
			if(max < arr[i]) max = arr[i];
		}
		
		max = Integer.max(max, (int) Math.ceil(cnt69/2.0));
		System.out.println(max);
	}
}
