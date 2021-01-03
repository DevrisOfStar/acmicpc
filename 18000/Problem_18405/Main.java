package Problem_18405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
//	3 3 // N K
//	1 0 2
//	0 0 0
//	3 0 0
//	2 3 2 S X Y
	static int N, K, S, X, Y;
	static int[][] map;
	static boolean[][] isvisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		N = Integer.parseInt(buffer.split(" ")[0]);
		K = Integer.parseInt(buffer.split(" ")[1]);
		map = new int[N][N];
		isvisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			buffer = br.readLine();
			StringTokenizer st = new StringTokenizer(buffer);
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		buffer = br.readLine();
		StringTokenizer st = new StringTokenizer(buffer);
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());	
		
		simulate();
		System.out.println(map[X-1][Y-1]);
	}
	static int[] dx = {0,1,-1,0};
	static int[] dy = {1,0,0,-1};
	
	static void simulate() {
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] > o2[2] ? 1 : -1;
			}
		});
		
		
		for(int i = 0; i <N; i++) {
			for(int j = 0; j <N;j++) {
				if(!isvisited[i][j] && map[i][j] > 0) {
					isvisited[i][j] = true;
					q.add(new int[] {i,j, map[i][j]});
				}
			}
		}
		
		Queue<int[]> qa = new LinkedList<>();
		while(!q.isEmpty()) qa.add(q.poll());
		
		while(!qa.isEmpty() && S-- > 0) {
			int qs = qa.size();
			while(qs-- > 0) {
				int[] data = qa.poll();
				for(int l = 0; l <4; l++) {
					int dx_ = data[0] + dx[l];
					int dy_ = data[1] + dy[l];		
					if(dx_ <0 || dy_ <0 || dx_ >=N || dy_>=N || isvisited[dx_][dy_]) continue;					
	
					map[dx_][dy_] = data[2];
					isvisited[dx_][dy_] = true;
					qa.add(new int[] {dx_, dy_, data[2]});
				}
			}
		}
	}
}
