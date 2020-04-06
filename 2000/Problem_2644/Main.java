package Problem_2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class data {
	int i;
	int cnt;

	public data(int i, int cnt) {
		this.i = i;
		this.cnt = cnt;
	}

}

public class Main {
	public static int[][] arr;

	public static void bfs(int N, int a, int b) {
		boolean[] isvisited = new boolean[N + 1];
		Queue<data> q = new LinkedList<>();
		isvisited[a] = true;
		q.add(new data(a,0));
		for (int i = 1; i <= N; i++) {
			while(!q.isEmpty()) {

				data d_ = q.poll();
				if(d_.i == b) { System.out.println(d_.cnt); return;} // exit code.
				for(int j = 1; j <= N; j++) {
					if(arr[d_.i][j] == 1 && !isvisited[j]) {
						q.add(new data(j, d_.cnt+1));
						isvisited[j] = true;
					
					}
				}
			}
		}
		
		System.out.println("-1"); // if not exit.
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" "); 
		int a = Integer.parseInt(temp[0]);
		int b = Integer.parseInt(temp[1]);
		int m = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		for(int i = 0 ; i < m ; i++) {
			String[] temp2 = br.readLine().split(" "); 
			int c = Integer.parseInt(temp2[0]);
			int d = Integer.parseInt(temp2[1]);
			arr[c][d] = 1;
			arr[d][c] = 1;
		}

		
		bfs(n,a,b);
	}
}
