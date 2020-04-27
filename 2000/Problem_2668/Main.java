package Problem_2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	static boolean[] isvisited;
	static boolean[] cycle;
	static int cnt;
	
	public static boolean DFS(int startNum, int nextNum) {
		if(isvisited[nextNum]) return false;
		isvisited[nextNum] = true;
		
		if(startNum == nextNum || DFS(startNum, arr[nextNum])) {
			cnt++;
			cycle[nextNum] = true;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		isvisited = new boolean[N+1];
		cycle = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 1; i<=N;i++) {
			for(int j = 1;j<=N;j++) isvisited[j] = cycle[j]; // init
			DFS(i, arr[i]);
		}
		System.out.println(cnt);
		for(int i = 1; i<=N;i++) 
			if(cycle[i]) System.out.println(i);
		
		
	}
}
