package Problem_2133;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[16];
		int t = sc.nextInt();
		arr[0] = 1;
		arr[1] = 3;
		arr[2] = 11;
		for(int i = 3; i<=t/2; i++) {
			for(int j = 1; j <=i ; j++) {
				arr[i] += arr[i-j] * ((j == 1) ? 3 : 2);
			}
		}
		if(t%2 == 0 && t != 0) {
			System.out.println(arr[t/2]);			
		}
		else {
			System.out.println(0);
		}
	}
}
