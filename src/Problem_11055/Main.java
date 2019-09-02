package Problem_11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = arr[0];
		int max = dp[0];
		for(int i = 1 ; i< arr.length; i++) {
			int min = 0;
			for(int j = 0; j<i; j++) {
				if(arr[i] > arr[j]) {
					if(dp[j] > min) min = dp[j];
				}
			}
			
			dp[i] = min + arr[i];
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}
