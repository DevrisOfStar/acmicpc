package Problem_15664;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] arr_;
	static StringBuilder sb;
	static ArrayList<String> list = new ArrayList<>();
 	public static void ans(int cnt,int idx) {
		if(cnt == M) {
			StringBuilder tb = new StringBuilder();
			for(int i = 0; i<M;i++) {
				tb.append(arr_[i]).append(" ");
			}
			tb.append("\n");
			if(list.contains(tb.toString())) {
				return;
			}
			else {
				sb.append(tb.toString());
				list.add(tb.toString());
			}
		}
		else {
			for(int i = idx+1; i < N;i++) {
				arr_[cnt] = arr[i];
				ans(cnt+1,i);
			}
			
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		StringTokenizer st;
		sb = new StringBuilder();
		N = Integer.parseInt(buffer.split(" ")[0]);
		M = Integer.parseInt(buffer.split(" ")[1]);
		
		arr = new int[N];
		arr_ = new int[M];
		
		buffer = br.readLine();
		st = new StringTokenizer(buffer, " ");
		
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		ans(0,-1);
		
		System.out.print(sb.toString());
	}
}
