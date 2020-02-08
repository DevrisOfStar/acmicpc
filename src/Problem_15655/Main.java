package Problem_15655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N,M;
	public static int[] arr;
	public static boolean[] b;
	static StringBuilder sb;
	public static void ans(int a, int cnt) {
		if(cnt == M) {
			for(int i = 0; i < N; i++) {
				if(b[i]) sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}
		else {
			for(int i = a; i < N; i++) {
				if(!b[i]) {
					b[i] =true;
					ans(i, cnt+1);
					b[i] = false;
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		
		N = Integer.parseInt(buffer.split(" ")[0]);
		M = Integer.parseInt(buffer.split(" ")[1]);
		
		arr = new int[N];
		b = new boolean[N];
		sb = new StringBuilder();
		
		buffer = br.readLine();
		
		StringTokenizer st = new StringTokenizer(buffer, " ");
		
		for(int i = 0; st.hasMoreTokens(); i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		ans(0, 0);
		System.out.print(sb.toString());
	}
}
