package Problem_15656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr;
	static int[] arr_;
	static StringBuilder sb;
	public static void ans(int cnt) {
		if(cnt == M) {
			for(int i = 0 ; i<M; i++) {
				sb.append(arr[arr_[i]]).append(" ");
			}
			sb.append("\n");
		}
		else if(cnt >= 1){
			for(int i = 0; i< N; i++) {
				arr_[cnt] = i;
				ans(cnt+1);
			}
		}
		else {
			for(int i = 0; i < N; i++) {
				arr_[cnt] = i;
				ans(cnt+1);
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		StringTokenizer st;
		N = Integer.parseInt(buffer.split(" ")[0]);
		M = Integer.parseInt(buffer.split(" ")[1]);
		arr = new int[N];
		arr_ = new int[M];
		sb = new StringBuilder();
		buffer = br.readLine();
		st = new StringTokenizer(buffer, " ");
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		ans(0);
		System.out.print(sb.toString());
	}
}
