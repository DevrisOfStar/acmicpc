package Problem_15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static boolean[] arr_;
	static int[] arr__;
	static StringBuilder sb;
	static ArrayList<String> list;

	public static void ans(int cnt) {
		if (cnt == M) {
			StringBuilder s = new StringBuilder();

			for (int i = 0; i < M; i++) {
				s.append(arr__[i]).append(" ");
			}

			if (list.contains(s.toString())) {
				return;
			} else {
				list.add(s.toString());
				sb.append(s.toString()).append("\n");
			}
		} else {
			for(int i = 0; i<N; i++) {
				if(!arr_[i]) {
					arr_[i] = true;
					arr__[cnt] = arr[i];
					ans(cnt+1);
					arr_[i] = false;
				}
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
		arr_ = new boolean[N];
		arr__ = new int[M];
		sb = new StringBuilder();
		list = new ArrayList<>();

		buffer = br.readLine();
		st = new StringTokenizer(buffer, " ");
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		ans(0);

		System.out.print(sb.toString());
	}
}
