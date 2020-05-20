package Problem_16917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M;
	static char[][] arr;
	static boolean[][][][] isvisited;
	static int[][] coins = new int[2][2];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { coins[0][0], coins[0][1], coins[1][0], coins[1][1] });
		isvisited[coins[0][0]][coins[0][1]][coins[1][0]][coins[1][1]] = true;

		int cnt = 0;

		while (!q.isEmpty() && cnt < 10) {
			cnt++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] data = q.poll();
				for(int k = 0; k<4;k++) {
					int da = data[0] + dx[k];
					int db = data[1] + dy[k];
					int dc = data[2] + dx[k];
					int dd = data[3] + dy[k];
					
					int out_coin = 0;

					if(da < 0 || db < 0 || da >= N || db >= M) 
						out_coin++;
					if(dc < 0 || dd < 0 || dc >= N || dd >= M) 
						out_coin++;
					
					if(out_coin == 2) continue;
					if(out_coin == 1) {
						System.out.println(cnt);
						return;
					}
					
					if(arr[da][db] =='#' && arr[dc][dd] =='#') continue;
					if(arr[da][db] =='#') {
						da -= dx[k];
						db -= dy[k];
					}
					else if(arr[dc][dd] =='#') {
						dc -= dx[k];
						dd -= dy[k];
					}
					if(da == dc && db == dd) continue;
					if(isvisited[da][db][dc][dd]) continue;
					
					q.add(new int[] {da,db,dc,dd});
					isvisited[da][db][dc][dd] = true;
					
					
				}
			}

		}
		System.out.println("-1");
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf = br.readLine();
		N = Integer.parseInt(bf.split(" ")[0]);
		M = Integer.parseInt(bf.split(" ")[1]);
		arr = new char[N][M];
		isvisited = new boolean[N][M][N][M];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			bf = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = bf.charAt(j);
				if (bf.charAt(j) == 'o') {
					coins[idx][0] = i;
					coins[idx++][1] = j;
					arr[i][j] = '.';
				}

			}
		}
		bfs();
	}
}
