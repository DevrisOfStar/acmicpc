package Problem_15665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] arr_;
	static StringBuilder sb;
	static ArrayList<String> list = new ArrayList<>();
	
 	public static void ans(int cnt) {
		if(cnt == M) {
			StringBuilder tb = new StringBuilder();
			for(int i = 0; i<M;i++) {
				tb.append(arr_[i]+" ");
			}
			list.add(tb.toString());
		}
		else {
			for(int i = 0; i < N;i++) {
				arr_[cnt] = arr[i];
				ans(cnt+1);
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
		ans(0);
		
		List result = list.stream().distinct().collect(Collectors.toList()); // 시간초과 해결
		
		for(Object obj : result) {
			sb.append(obj.toString()).append("\n");
		}
		
		
		System.out.print(sb.toString());
	}
}
