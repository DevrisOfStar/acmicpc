package Problem_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N];
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < N; i++) {
			int min = 0;
			for(int j = 0; j<i; j++) {
				if(arr[i] > arr[j]) { // 감소하는부분
					if(min < dp[j]) { // dp[j]와 최소값을 비교
						min = dp[j];
					}
				}
			}
			dp[i] = min + 1; // i까지의 가장 긴 증가하는 부분 수열 == 최소값 + 1
			if(dp[i] > max) { // max하고 비교
				max = dp[i];
			}
		}
		
		System.out.println(max);
		
	}
}
