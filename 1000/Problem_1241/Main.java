package Problem_1241;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		final int MAX_NUMBER = 1000001;
		int[] cnt = new int[MAX_NUMBER];
		int[] arr = new int[N];
		int[] ans = new int[N];
		for(int i = 0; i<N;i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N;i++) cnt[arr[i]]++;
		
		for(int i = 0; i<N; i++) {
			for(int k = 1; k*k <=arr[i];k++) {
				if(arr[i]%k == 0) {
					if(arr[i]/k !=k) ans[i] += cnt[k] + cnt[arr[i]/k];
					else ans[i] += cnt[k];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N; i++) 
			sb.append(ans[i]-1).append("\n");
		
		System.out.println(sb.toString());
	}
}
