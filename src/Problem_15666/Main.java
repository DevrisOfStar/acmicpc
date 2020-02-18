package Problem_15666;

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
	static ArrayList<String> list = new ArrayList<>();
	static void ans(int cnt, int idx) {
		if (cnt == M) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<M;i++) {
				for(int j = i+1; j<M;j++) {
					if(arr_[i] > arr_[j]) return;
				}
			}
			for(int i = 0; i<M;i++) {
				sb.append(arr_[i]+" ");
			}
			list.add(sb.toString());
		} else {
			for(int i = idx; i<N;i++) {
				arr_[cnt] = arr[i];
				ans(cnt+1,idx);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(buffer.split(" ")[0]);
		M = Integer.parseInt(buffer.split(" ")[1]);

		arr = new int[N];
		arr_ = new int[M];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);
		ans(0, 0);
		
		List lists_ = list.stream().distinct().collect(Collectors.toList());
		
		for(Object obj : lists_) {
			sb.append(obj.toString() + "\n");
		}
		System.out.print(sb.toString());
		
	}
}
