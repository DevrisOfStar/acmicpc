package Problem_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 4:40
public class Main {
	static int N;
	static int[][] arr;
	static boolean[] team;
	static int min = Integer.MAX_VALUE;

	public static void getAnswer(int idx, int cnt) {
		if (cnt == N / 2) { // 팀이 나눠진 경우
			int a = 0, b = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) // 번호가 같은 사람끼린 시너지가 존재하지않으므로
						continue;
					if (team[i] == true && team[j] == true) { // 스타트팀일때,
						a += (arr[i][j] + arr[j][i]);
					} else if (team[i] == false && team[j] == false) { // 링크팀일때,
						b += (arr[i][j] + arr[j][i]);
					}
				}
			}
			int c = Math.abs((a - b)/2);
			if (min > c)
				min = c;
		} else { // 팀 선정 : N/2명을 선출
			for (int i = idx; i < N; i++) {
				if (!team[i]) {
					team[i] = true;
					getAnswer(i, cnt + 1);
					team[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		team = new boolean[N];
		String str;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str.split(" ")[j]);
			}
		}
		getAnswer(0, 0);
		System.out.println(min);
	}
}
