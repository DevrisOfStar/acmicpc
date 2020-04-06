package Problem_9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean[][] arr = new boolean[1001][1001];
	static boolean[] isvisited;  

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String str;
		for (int t = 1; t <= T; t++) {
			str = br.readLine();
			int N = Integer.parseInt(str.split(" ")[0]);
			int M = Integer.parseInt(str.split(" ")[1]);
			isvisited = new boolean[N+1];
			
			for(int i = 0; i<M;i++) {
				str = br.readLine();
				int a = Integer.parseInt(str.split(" ")[0]);
				int b = Integer.parseInt(str.split(" ")[1]);
				arr[a][b] = true;
				arr[b][a] = true;
			}
			
			System.out.println(N-1); // 무조건 모든 그래프를 연결할 수 있는 최대 간선의 수
			for(int i = 0; i < N; i++) {
				Arrays.fill(arr[i], false);
			}
		}
	}
}
