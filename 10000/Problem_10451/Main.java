package Problem_10451;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr = new int[1001];
	static boolean[] isvisited = new boolean[1001];
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t<=T; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			for(int i = 1; i<=N; i++) {
				isvisited[i] = false;
				arr[i] = 0;
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 1 ;i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());
						
			for(int i = 1; i<=N; i++) {
				if(!isvisited[i]) {
					answer++;
					dfs(i);
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int i) {
		isvisited[i] = true;
		if(!isvisited[arr[i]]) dfs(arr[i]);
	}
}
