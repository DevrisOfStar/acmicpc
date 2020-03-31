package Problem_1929;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean[] arr = new boolean[1000001];
		arr[0] = true;
		arr[1] = true;
		for(int i = 2; i<=1000000;i++) {
			if(arr[i]) continue;
			for(int j = i*2; j <=1000000;j+=i) {
				arr[j] = true;
			}
		}
		
		for(int a = M; a <= N; a++)
			if(!arr[a]) System.out.println(a);
	}
	
}
