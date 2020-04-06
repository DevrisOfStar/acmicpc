package Problem_17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D;
	static int[][] playmap;
	static int[][] map;
	static int[] archers;
	static int max = Integer.MIN_VALUE;
	static int cnt;

	public static void print(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%d\t", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				playmap[i][j] = map[i][j];
			}
		}
	}

	public static void move() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (playmap[i][j] == 2) {
					cnt++;
					playmap[i][j] = 0;
				}
			}
		}
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < M; j++) {

				playmap[i + 1][j] = playmap[i][j];
			}
		}
		for (int i = 0; i < M; i++) {
			playmap[0][i] = 0;
		}
	}

	public static boolean isvalid() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (playmap[i][j] == 1)
					return true;
			}
		}
		return false;
	}

	public static void playgame(int r, int idx, int target) {
		if (r == 0) {
			// do game
			
			cnt = 0;
			init(); // map -> playmap
			while (isvalid()) {
				getEmeny();
				//if(archers[0] == 0 && archers[1] == 2 && archers[2] == 4) print(playmap);
				move();
			}

			if (max < cnt) {
				
				max = cnt;

			}
			return;
		} else if (target == M) {
			return;
		} else {
			archers[idx] = target;
			playgame(r - 1, idx + 1, target + 1);
			playgame(r, idx, target + 1);
		}
	}

	public static void getEmeny() {
		for (int k = 0; k < 3; k++) {
			int a = N, b = M;
			int min = Integer.MAX_VALUE;
			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					if (playmap[i][j] != 0 && Math.abs(N - i) + Math.abs(j - archers[k]) < min && Math.abs(N - i) + Math.abs(j - archers[k]) <= D) {
						a = i;
						b = j;
						min = Math.abs(N - i) + Math.abs(j - archers[k]);
					} 
					else if(playmap[i][j] != 0 && Math.abs(N - i) + Math.abs(j - archers[k]) == min) {
						if(b > j) {
							a = i;
							b = j;
							min = Math.abs(N - i) + Math.abs(j - archers[k]);	
						}
					}
				}
			}
			if (a == N || b == M)
				continue;
			playmap[a][b] = 2;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		playmap = new int[N][M];
		map = new int[N][M];
		archers = new int[3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		playgame(3, 0, 0);
		System.out.println(max);
	}
}
