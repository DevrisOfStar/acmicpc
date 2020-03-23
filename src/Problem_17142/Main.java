package Problem_17142;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[][] isvisited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int min = Integer.MAX_VALUE;
	static int[] virus_arr;
	static ArrayList<int[]> virus = new ArrayList<>();

	public static void bfs(int idx, int number) {
		if (idx == M) {
			Queue<int[]> q = new LinkedList<>();
			Queue<int[]> q2 = new LinkedList<>();
			System.out.println(Arrays.toString(virus_arr));

			for (int i = 0; i < virus_arr.length; i++) {
				arr[virus.get(virus_arr[i])[0]][virus.get(virus_arr[i])[1]] = 2;
				q.add(new int[] { virus.get(virus_arr[i])[0], virus.get(virus_arr[i])[1], 0 });
				isvisited[virus.get(virus_arr[i])[0]][virus.get(virus_arr[i])[1]] = true;
			}
			int cnt = 0;
			for (; !q.isEmpty(); cnt++) {
				int j = q.size();
				for(; !q.isEmpty();) {
					int[] data = q.poll();
					
					for (int i = 0; i < 4; i++) {
						int dx_ = data[0] + dx[i];
						int dy_ = data[1] + dy[i];

						if (dx_ < 0 || dy_ < 0 || dx_ >= N || dy_ >= N)
							continue;
						if (arr[dx_][dy_] == 1)
							continue;
						if (arr[dx_][dy_] == -1 && !isvisited[dx_][dy_]) {
							isvisited[dx_][dy_] = true;
							q.add(new int[] { dx_, dy_});
						} else if (arr[dx_][dy_] == 0 && !isvisited[dx_][dy_]) {
							isvisited[dx_][dy_] = true;
							q2.add(new int[] { dx_, dy_});
						}
					}
				}
				for(;!q2.isEmpty();) q.add(q2.poll());
				
				if(!Arrays.toString(virus_arr).equals("[0, 1, 2]")) continue;
				System.out.println(cnt);
				for (int i = 0; i < N; i++) {
					for (int k = 0; k < N; k++) {
						if ((arr[i][k] == 0 || arr[i][k] == 2 || arr[i][k] == -1) && isvisited[i][k])
							System.out.print("1 ");
						else
							System.out.print("0 ");
					}
					System.out.println();
				}	
				System.out.println();
			}
			
			boolean flag = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if ((arr[i][j] == 0 || arr[i][j] == 2 || arr[i][j] == -1) && !isvisited[i][j]) {
						flag = false;
						break;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if ((arr[i][j] == 0 || arr[i][j] == 2 || arr[i][j] == -1) && isvisited[i][j])
						System.out.print("1 ");
					else
						System.out.print("0 ");
				}
				System.out.println();
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					isvisited[i][j] = false;
				}
			}
			for (int i = 0; i < virus_arr.length; i++) {
				arr[virus.get(virus_arr[i])[0]][virus.get(virus_arr[i])[1]] = -1;
			}
			if (flag) {
				System.out.println(cnt);
				if (min > cnt)
					min = cnt;
			}

			System.out.println();

		} else if (number == virus.size())
			return;
		else {
			virus_arr[idx] = number;
			bfs(idx + 1, number + 1);
			bfs(idx, number + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);
		arr = new int[N][N];
		isvisited = new boolean[N][N];
		if (M == 0)
			System.out.println("-1");
		virus_arr = new int[M];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					virus.add(new int[] { i, j });
					arr[i][j] = -1;
				}
			}
		}
		bfs(0, 0);
		System.out.println(min);
	}
}
