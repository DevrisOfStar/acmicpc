package Problem_18290;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, M, K;
	static int[][] arr;
	static boolean[][] is_;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int max = Integer.MIN_VALUE;
	public static void answer(int i, int j, int num, int cnt) {
		if(cnt == K) { // 개수가 다 채워졌으면, 최대값 계산
			if(max < num) max = num;
		}
		else {
			for(int k = i; k < N; k++) {
				for(int l = 0; l<M;l++) {
					if(!is_[k][l]) {
						boolean flag = true;
						for(int m = 0 ; m < 4; m++) { // 4방향 확인
							if(k+dx[m] < 0 || k+dx[m] >= N || l+dy[m] < 0 || l+dy[m] >= M) continue;
							if(is_[k+dx[m]][l+dy[m]]) flag = false; // 선택한적이 있으면, flag false 
						}
						if(flag) { // 4 방향 모두 선택한적이 없으면, 선택 후 진행
							is_[k][l] = true;
							answer(k,l,num+arr[k][l], cnt+1); // 선택한 격자판에서 다시 시작
							is_[k][l] = false;
						}
					}
				}
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);
		K = Integer.parseInt(str.split(" ")[2]);
		arr = new int[N][M];
		is_ = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str.split(" ")[j]);
			}
		}
		
		answer(0,0,0,0);
		System.out.println(max);
	}
}
