package Problem_2725;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		int C = sc.nextInt();
		int[] arr = new int[1001];
		arr[1] = 3;
		for(int i = 2; i<=1000; i++) {
			arr[i] = arr[i-1];
			for(int j=0; j<=i;j++) {
				if(gcd(i, j)==1) arr[i]+=2;
			}
		}
		for(int c = 0; c < C; c++) {
			System.out.println(arr[sc.nextInt()]);
		}
	}
	
	static int gcd(int a, int b) {
		int tmp, n;
		if(a < b) {
			tmp = a;
			a = b;
			b = tmp;
		}
		
		while(b!=0) {
			 n = a%b;
			 a = b;
			 b = n;
		}
		return a;
	}
}
