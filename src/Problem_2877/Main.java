package Problem_2877;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int n;
		int sum = 0;
		for (n = 1; n <= 32; n++) {
			sum += Math.pow(2, n);
			if (sum >= k)
				break;
		}
		k = (int) (k - Math.pow(2, n) + 1);
		int[] arr = new int[n];
		int size = n;
		int i = 0;
		do {
			arr[size - 1 - i] = k % 2;
			k = k / 2;
			i++;
		} while (k > 0);

		for (i = 0; i < arr.length; i++)
			if(arr[i] == 1) sb.append("7"); else sb.append("4");
		
		System.out.println(sb.toString());
	}
}
