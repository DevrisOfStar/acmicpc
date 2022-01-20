package Problem_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		long[] arr = new long[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<= N; i++) {arr[i] = arr[i-1] + Long.parseLong(st.nextToken());}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(arr[b] - arr[a-1]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
