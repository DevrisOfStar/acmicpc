package Problem_17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] pop;
	static boolean[] isSelected;
	static boolean[][] isClosed;
	static boolean[] isvisited;
	static int min_value = Integer.MAX_VALUE;

	static void dfs(int idx, boolean flag) {
		isvisited[idx] = true;
		for(int i = 0; i<N; i++) {
			if(!isClosed[idx][i]) continue;
			if(isvisited[i]) continue;
			if(isSelected[i] != flag) continue;
			dfs(i, flag);
		}
	}

	static void getAnswer(int idx, int c) {
		if (idx == N && c > 0) {
			int a = 0, b = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i])
					a = i;
				else
					b = i;
			}
			for (int i = 0; i < N; i++)
				isvisited[i] = false;
			dfs(a, true);
			int group_true = 0;
			int true_value = 0;
			for (int i = 0; i < N; i++)
				if (isvisited[i]) {
					group_true++;
					true_value += pop[i];
				}

			for (int i = 0; i < N; i++)
				isvisited[i] = false;
			dfs(b, false);
			int group_false = 0;
			int false_value = 0;
			for (int i = 0; i < N; i++)
				if (isvisited[i]) {
					group_false++;
					false_value += pop[i];
				}

			if (c != group_true || (N - c) != group_false) return;
			if(min_value > Math.abs(false_value - true_value)) min_value = Math.abs(false_value - true_value); 

		} else if (idx == N)
			return;
		else {
			getAnswer(idx + 1, c);
			isSelected[idx] = true;
			getAnswer(idx + 1, c + 1);
			isSelected[idx] = false;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pop = new int[N];
		isClosed = new boolean[N][N];
		isSelected = new boolean[N];
		isvisited = new boolean[N];
		String str = br.readLine();
		for (int i = 0; i < N; i++)
			pop[i] = Integer.parseInt(str.split(" ")[i]);

		for (int i = 0; i < N; i++) {
			str = br.readLine();
			int cnt = Integer.parseInt(str.split(" ")[0]);
			for (int j = 1; j <= cnt; j++) {
				isClosed[i][Integer.parseInt(str.split(" ")[j]) - 1] = true;
			}
		}

		getAnswer(0, 0);

		if(min_value != Integer.MAX_VALUE) {
			System.out.println(min_value);
			return;
		}
		System.out.println("-1");

	}
}
