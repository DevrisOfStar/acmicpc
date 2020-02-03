package Problem_12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] board;
	static int answer;
	static int N;

	public static void calc(int num) {
		boolean canplus = true;
		
		int[] q = new int[20];
		int p = -1;
		
		switch (num) {
		case 1: // up
			for(int j = 0; j<N;j++) {
				canplus = true;
				for(int i = 0; i<N;i++) {
					if(board[i][j] != 0) {
						q[++p] = board[i][j];
						board[i][j] = 0;
					}
					else {
						continue;
					}
					if(p >= 1) {
						int temp = q[p];
						int temp2 = q[p-1];
						if(temp2 == temp && canplus) {
							temp*=2;
							q[p] = 0;
							q[--p] = temp;
							canplus = false;
							continue;
						}
					}
					if(!canplus) canplus = true;
				}
				
				int size = p;
				for(int i= 0; i<=p;i++) {
					board[i][j] = q[i];
				}
				
				for(int i = size+1; i<N;i++) {
					board[i][j] = 0;
				}
				Arrays.fill(q, 0);
				p = -1;
			}
			break;
		case 2: // down
			for(int j = 0; j<N;j++) {
				canplus = true;
				for(int i =N-1; i>=0;i--) {
					if(board[i][j] != 0) {
						q[++p] = board[i][j];
						board[i][j] = 0;
					}
					else {
						continue;
					}
					if(p >= 1) {
						int temp = q[p];
						int temp2 = q[p-1];
						if(temp2 == temp && canplus) {
							temp*=2;
							q[p] = 0;
							q[--p] = temp;
							canplus = false;
							continue;
						}
					}
					if(!canplus) canplus = true;
				}
				
				int size = p;
				for(int i= 0; i<=p;i++) {
					board[N-1-i][j] = q[i];
				}
				
				for(int i = size+1; i<N;i++) {
					board[N-1-i][j] = 0;
				}
				Arrays.fill(q, 0);
				p = -1;
			}
			break;
		case 3: // left
			for(int i = 0; i<N;i++) {
				canplus = true;
				for(int j = 0; j<N;j++) {
					if(board[i][j] != 0) {
						q[++p] = board[i][j];
						board[i][j] = 0;
					}
					else {
						continue;
					}
					if(p >= 1) {
						int temp = q[p];
						int temp2 = q[p-1];
						if(temp2 == temp && canplus) {
							temp*=2;
							q[p] = 0;
							q[--p] = temp;
							canplus = false;
							continue;
						}
					}
					if(!canplus) canplus = true;
				}
				
				int size = p;
				for(int j= 0; j<=p;j++) {
					board[i][j] = q[j];
				}
				
				for(int j = size+1; j<N;j++) {
					board[i][j] = 0;
				}
				Arrays.fill(q, 0);
				p = -1;
			}
			break;
		case 4: // right
			for(int i = 0; i<N;i++) {
				canplus = true;
				for(int j =N-1; j>=0;j--) {
					if(board[i][j] != 0) {
						q[++p] = board[i][j];
						board[i][j] = 0;
					}
					else {
						continue;
					}
					if(p >= 1) {
						int temp = q[p];
						int temp2 = q[p-1];
						if(temp2 == temp && canplus) {
							temp*=2;
							q[p] = 0;
							q[--p] = temp;
							canplus = false;
							continue;
						}
					}
					if(!canplus) canplus = true;
				}
				
				int size = p;
				for(int j= 0; j<=p;j++) {
					board[i][N-1-j] = q[j];
				}
				
				for(int j = size+1; j<N;j++) {
					board[i][N-1-j] = 0;
				}
				Arrays.fill(q, 0);
				p = -1;
			}
			break;

		}
	}

	public static void dfs(int cnt) {
		if (cnt == 5) { // end condition
			for(int i = 0; i < N; i++) {
				for(int j = 0; j <N;j++) {
					if(answer < board[i][j]) answer = board[i][j];
				}
			}
		} else { // continue condition
			int[][] copy_board = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					copy_board[i][j] = board[i][j];
				}
			}

			for (int i = 1; i <= 4; i++) {
				calc(i);
				dfs(cnt + 1);
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						 board[j][k] = copy_board[j][k];
					}
				}
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 2020-01-31 dfs - 현재상태를 저장하고 다음상태로 이동.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = Integer.MIN_VALUE;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		String buffer;
		for (int i = 0; i < N; i++) {
			buffer = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(buffer.split(" ")[j]);
			}
		}

	
		dfs(0);
		System.out.println(answer);
	}

}
