package Problem_15661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static boolean[] isSelected;
	static int min = Integer.MAX_VALUE;

	static void dfs(int idx, int cnt) {
		if (cnt == n / 2) {
			int Link = 0;
			int Start = 0;
			int num = 0;
			for(int i = 0; i<n;i++) {
				for(int j = 0; j<n; j++) {
					if(i == j) continue;
					if(isSelected[i] && isSelected[j]) {
						Link += arr[i][j]; 
					}
					else if(!isSelected[i] && !isSelected[j]) {
						Start += arr[i][j];
					}
				}
			}
			num = Math.abs(Link - Start);
			if(min > num) min = num;
		} else {
			for (int i = idx; i < n; i++) {
				if (isSelected[i])
					continue;
				isSelected[i] = true;
				dfs(i, cnt + 1);
				isSelected[i] = false;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		isSelected = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		System.out.println(min);
	}
}
