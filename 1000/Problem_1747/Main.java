package Problem_1747;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] arr = new boolean[2000001];		
		int N = sc.nextInt();
		Arrays.fill(arr, true);
		arr[1] = false;
		for(int i = 2; i<=2000000;i++) {
			if(!arr[i]) continue;
			for(int j = i+i; j<=2000000;j+=i) {
				arr[j] = false;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = N; i<= 2000000; i++)
			if(arr[i]) {
				sb.append(i);
				if(sb.toString().equals(sb.reverse().toString())) {
					System.out.println(i);
					return;	
				}
				sb.setLength(0);
			}
	}
}
