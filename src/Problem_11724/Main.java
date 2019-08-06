package Problem_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	
	public static void bfs(boolean[][] arr) {
		int N = arr.length-1;
		boolean[] isvisited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;
		for(int i = 1; i <=N;i++) {
			if(!isvisited[i]) {
				isvisited[i] = true;
				q.offer(i);
				cnt++;
			}
			
			while(!q.isEmpty()) {
				int data = q.poll();
				
				for(int j = 1; j<=N; j++) {
					if(!isvisited[j] && arr[data][j])
						{
							q.offer(j);
							isvisited[j] = true;
						}
				}
			}
		}
		System.out.println(cnt);
	}
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		boolean[][] arr = new boolean[N+1][N+1];
		for(int i = 0 ; i < M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			arr[a][b] = true;
			arr[b][a] = true;
		}
		
		bfs(arr);
		
	}
}
