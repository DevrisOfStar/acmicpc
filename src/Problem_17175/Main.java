package Problem_17175;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long[] arr;
	static long a = 1000000007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		if(n == 0) {
			System.out.println("1");
			return;
		}
		arr = new long[n + 1];

		arr[0] = 1;
		arr[1] = 1;
		
		for(int i = 2; i<=n;i++) {
			arr[i] = (1+arr[i-2]+arr[i-1]);
			arr[i] %= a;
		}
			
		
		System.out.println(arr[n]);
	}
}
