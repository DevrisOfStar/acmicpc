package Problem_17281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] player;
	static int N; // 이닝 수
	static int max = Integer.MIN_VALUE;
	static int out_cnt;
	static int player_number;
	static int[] order = new int[9];
	static boolean[] isvalid = new boolean[9];
	static int[] home = new int[4];

	public static void playGame(int n) {
		if (n == 9) {
			int score = 0;
			int number;
			player_number = -1;
			for (int i = 0; i < N; i++) {
				out_cnt = 0;
				for (int t = 1; t <= 3; t++)
					home[t] = 0; // 초기화
				while (out_cnt < 3) { // 아웃카운트가 3이 될때까지 계속
					player_number = (player_number + 1) % 9;
					number = player[i][order[player_number]];
					switch (number) {
					case 0:
						out_cnt++;
						break;
					case 1:
					case 2:
					case 3:
						for (int t = 3; t >= 1; t--) {
							if (home[t] == 1) {
								if (t + number >= 4) { // 홈인 할 수 있으면
									score++;
									home[t] = 0;
								} else { // 홈인 할 수 없는 경우
									home[t + number] = 1;
									home[t] = 0;
								}
							}
						}

						home[number] = 1;

						break;
					case 4: // 홈런 친 경우
						score++;
						for (int t = 1; t <= 3; t++) { 
							if (home[t] == 1)
								score++;
							home[t] = 0;
						}
						break;
					}
				}
			}

			if (score > max)
				max = score;
			return;

		} else if (n == 3) {
			playGame(n + 1); // 1번타자를 4번타자로 지정
		} else {
			for (int i = 0; i < 9; i++) {
				if (!isvalid[i]) {
					isvalid[i] = true;
					order[n] = i;
					playGame(n + 1);
					order[n] = 0;
					isvalid[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		player = new int[N][9];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		order[3] = 0;
		isvalid[0] = true;
		playGame(0);
		System.out.println(max);
	}

}
