package Problem_3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static int N, K, L;
	public static int[][] map;
	public static ArrayList<int[]> snake = new ArrayList<>();
	public static int[][] insts;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static int s_dir = 1; // right ---->>
	public static int t = 0;

	public static void simulate() {
		int insts_idx = 0;
		do {
			int[] snake_head = snake.get(snake.size() - 1).clone(); // 마지막 머리
			int[] d = new int[2];
			
			d[0] = snake_head[0] + dx[s_dir];
			d[1] = snake_head[1] + dy[s_dir];
			t++;
			
			if (d[0] <= 0 || d[0] > N || d[1] <= 0 || d[1] > N) break;
			// 충돌
			boolean isexisted = false;
			for (int i = 0; i < snake.size(); i++) {
				int[] temp = snake.get(i);
				if(d[0] == temp[0] && d[1] == temp[1]) isexisted = true;
			}
			if(isexisted) break;
			
			snake.add(d);
			
			if (map[d[0]][d[1]] == -1) {
				map[d[0]][d[1]] = 0;
			} else {
				snake.remove(0);
			}
			
	
			if ( insts_idx < insts.length && insts[insts_idx][0] == t) {
				if (insts[insts_idx][1] == 1) { // 왼쪽
					s_dir += 3;
					s_dir %= 4;
				} else { // 오른쪽
					s_dir += 1;
					s_dir %= 4;
				}
				insts_idx++;
			}
			// 데이터 진행 확인용
//			System.out.println("------------"+ t + "--------" + s_dir);
//			
//			for (int i = 0; i < snake.size(); i++) {
//				int[] temp = snake.get(i);
//				map[temp[0]][temp[1]] = 2;
//			}
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= N; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			for (int i = 0; i < snake.size(); i++) {
//				int[] temp = snake.get(i);
//				map[temp[0]][temp[1]] = 0;
//			}

		} while (true);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer;
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			buffer = br.readLine();
			map[Integer.parseInt(buffer.split(" ")[0])][Integer.parseInt(buffer.split(" ")[1])] = -1;
		}

		L = Integer.parseInt(br.readLine());
		insts = new int[L][2];
		for (int i = 0; i < L; i++) {
			buffer = br.readLine();
			insts[i][0] = Integer.parseInt(buffer.split(" ")[0]);
			insts[i][1] = buffer.split(" ")[1].equals("D") ? -1 : 1; // 오른쪽 : 왼쪽
		}

		snake.add(new int[] { 1, 1 });
		simulate();
		System.out.println(t);
	}
}
