package Problem_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 모든 경우의 수에 대해서 BFS 적용 */
class data{
	int x;
	int y;
	public data(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int[][] temp;
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int M;
	static int N;
	public static void reset() {
		for(int i = 0; i < temp.length; i++) {
			for(int j = 0; j <temp[0].length; j++ ) {
				map[i][j] = temp[i][j]; 
			}
		}	
	}
	public static void bfs() {
		data d1, d2, d3;
		
		reset();
		int max = Integer.MIN_VALUE;
		for(int i1=0; i1<M;i1++) {
			for(int j1=0;j1<N;j1++) {
				if(map[i1][j1] != 0) continue;
				for(int i2=0; i2<M;i2++) {
					for(int j2=0;j2<N;j2++) {
						if(i1==i2 && j1==j2) continue;
						if(map[i2][j2] !=0) continue;
						
						for(int i3=0; i3<M;i3++) {
							for(int j3=0;j3<N;j3++) {
								// 3 좌표가 다 다르고, 벽이 아닌경우
								if(i1==i2 && j1==j2) continue;
								if(i1==i3 && j1==j3) continue;
								if(i2==i3 && j2==j3) continue;
								if(map[i3][j3] !=0) continue;
								
								for(int i = 0; i < M ; i++) {
									for(int j = 0; j<N; j++) {
										if(map[i][j] == 2) {
												// 벽을 세우고, bfs 진행 : 바이러스 퍼짐
												map[i1][j1] = 1;
												map[i2][j2] = 1;
												map[i3][j3] = 1;
												
												Queue<data> q = new LinkedList<data>();
												q.add(new data(i,j));
												
												while(!q.isEmpty()) {
													data d = q.poll();
													for(int k = 0 ; k < 4; k++) {
														int x_ = d.x + dx[k];
														int y_ = d.y + dy[k];
														
														if( x_<0 || x_>=M || y_<0 || y_>=N) continue;
														if(map[x_][y_] == 1 || map[x_][y_] == 2) continue;
														q.add(new data(x_,y_));
														map[x_][y_] = 2;
													}
												}
												
												
										}
									}
								}
								int cnt = 0;
								// 안전영역 카운트 : 0은 안전영역, 2는 감염구역
								for(int i = 0 ; i < M; i++) {
									for(int j = 0 ; j < N; j++) {
										if(map[i][j] == 0) cnt++;
									}
								}
								max = Math.max(max, cnt);
								reset();
							}
						}
					}
				}
			}
		}
		System.out.println(max);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		
		temp = new int[M][N];
		 map = new int[M][N];
		 
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			for(int j = 0; j <N; j++ ) {
				temp[i][j] = s.charAt(2*j) - '0';
			}
		}
		
		bfs();
	}
}
