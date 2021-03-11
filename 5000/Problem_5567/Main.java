package Problem_5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, m;
	static boolean[][] arr;
	static boolean[] isvisited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new boolean[n+1][n+1];
		isvisited = new boolean[n+1];
		String[] buf;
		int a = 0, b = 0;
		for(int i = 0; i<m; i++) {
			buf = br.readLine().split(" ");
			a = Integer.parseInt(buf[0]);
			b = Integer.parseInt(buf[1]);
			arr[a][b] = true;
			arr[b][a] = true;
		}		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1, 0});
		isvisited[1] = true;
		
		while(!q.isEmpty()) {
			int[] data = q.poll();
			for(int i = 1; i<= n; i++) {
				if(arr[data[0]][i] && !isvisited[i] && data[1] < 2) {
					q.add(new int[] {i, data[1]+1});
					isvisited[i] = true;
				}
			}
		}
		int cnt = 0;
		for(int i = 2; i<= n; i++) if(isvisited[i]) cnt++;
		
		System.out.println(cnt);
		
	}
}
