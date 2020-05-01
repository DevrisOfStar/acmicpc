package Problem_4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static class data implements Comparable<data>{
		int sum;
		int x;
		int y;
		
		public data(int sum, int x, int y) {
			super();
			this.sum = sum;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(data o) {
			if(this.sum < o.sum) return -1;
			return 1;
		}
		
		
	}
	static int N;
	static int[][] arr = new int[125][125];
	static int[][] dist = new int[125][125];
	static boolean[][] isvisited = new boolean[125][125];
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void answer() {
		PriorityQueue<data> q = new PriorityQueue<>();
		q.add(new data(arr[0][0],0,0));
		dist[0][0] = arr[0][0];
		isvisited[0][0] = true;
		
		while(!q.isEmpty()) {
			data d = q.poll();
			for(int k = 0; k<4;k++) {
				int dx_ = d.x + dx[k];
				int dy_ = d.y + dy[k];
				if(dx_ < 0 || dy_ < 0 || dx_ >=N || dy_ >= N) continue;
				if(isvisited[dx_][dy_]) continue;
				int sum_ = d.sum + arr[dx_][dy_];
				if(dist[dx_][dy_] < sum_) continue;
				
				q.add(new data(sum_, dx_, dy_));
				dist[dx_][dy_] = sum_;
				isvisited[dx_][dy_] = true;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		int cnt = 1;
		do {
			N = Integer.parseInt(br.readLine());
			if(N == 0) return;
			
			for(int i = 0; i<N;i++) {
				str = br.readLine();
				for(int j = 0; j<N;j++) {
					arr[i][j] = str.charAt(j*2) - '0';
					dist[i][j] = Integer.MAX_VALUE;
					isvisited[i][j] = false;
				}
			}
			
			answer();
			System.out.println("Problem " + cnt++ + ": " + dist[N-1][N-1]);
		}while(N != 0);
	}
	
}
