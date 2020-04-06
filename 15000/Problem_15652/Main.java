package Problem_15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N,M;
	public static int[] arr;
	public static StringBuilder sb;
	public static void ans(int cnt) {
		if(cnt == M) {
			for(int i = 0 ; i < M ; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}
		else if(cnt >= 1){
			for(int i = arr[cnt-1]; i <= N;i++) {
				arr[cnt] = i;
				ans(cnt+1);
			}
		}
		else {
			for(int i = 1; i <= N;i++) {
				arr[cnt] = i;
				ans(cnt+1);
			} 
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		N = Integer.parseInt(buffer.split(" ")[0]);
		M = Integer.parseInt(buffer.split(" ")[1]);
		arr = new int[M];
		sb = new StringBuilder();
		ans(0);
		System.out.print(sb.toString());
	}
}
