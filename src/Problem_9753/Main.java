package Problem_9753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	static int N = 100000;
	static boolean[] isprime = new boolean[N+1];
	static ArrayList<Integer> arr = new ArrayList<>();
	public static int ans(int num) {
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i<arr.size(); i++) {
			for(int j = 0; j<arr.size(); j++) {
				if(i==j) continue;
				if(arr.get(i) * arr.get(j) >= num) {
					min = Math.min(min, arr.get(i) * arr.get(j));
					break;
				}
			}
		}
		
		return min;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		Arrays.fill(isprime, true);
		isprime[1] = false;
		
		for(int i = 2; i<=N;i++) {
			if(isprime[i]) {
				for(int j = i; j<=N; j=j+i) {
						isprime[j] = false;
				}
				isprime[i] = true;
			}
		}
		for(int i = 1; i<=N;i++) {
			if(isprime[i]) arr.add(i);
		}
		
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t =1; t<=T; t++) {
			sb.append(ans(Integer.parseInt(br.readLine()))).append("\n");
		}
		
		System.out.println(sb);
		
		
	}
}
