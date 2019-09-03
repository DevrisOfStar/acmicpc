package Problem_11722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = 1;
		int max = dp[0];
		for(int i = 1; i < N; i++) {
			int min = 0;
			for(int j = 0; j<i; j++) {
				if(arr[j] > arr[i]) {
					if(min < dp[j]) min = dp[j];
				}
			}
			dp[i] = min+1;
			
			if(max < dp[i]) max = dp[i];
		}
		System.out.println(max);
		
	}
}
