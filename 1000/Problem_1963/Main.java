package Problem_1963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int a, b;
	static boolean[] isPrime;
	static boolean[] isvisited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String bf; 
		isPrime = new boolean[10000];
		isvisited = new boolean[10000];
		Arrays.fill(isPrime, true);
		for(int i = 2; i<=9999; i++) {
			if(isPrime[i]) {
				for(int j = i*2; j<=9999;j+=i) {
					isPrime[j] = false;
				}
			}
		}
		for(int i = 1 ; i<=T ; i++) {
			bf = br.readLine();
			a = Integer.parseInt(bf.split(" ")[0]);
			b = Integer.parseInt(bf.split(" ")[1]);
			Arrays.fill(isvisited, false);
			min = Integer.MAX_VALUE;
			bfs(a,b);
			if(min == Integer.MAX_VALUE) {
				System.out.println("Impossible");
			}
			else {
				System.out.println(min);
			}
		}
	}
	
	public static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {a, 0});
		isvisited[a] = true;
		
		while(!q.isEmpty()) {
			int[] data = q.poll();
			if(data[0] == b) {
				if(min > data[1]) min = data[1];
			}
			
			char[] charArray = String.valueOf(data[0]).toCharArray();
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j <= 9;j++) {
					charArray = String.valueOf(data[0]).toCharArray();
					charArray[i] = (char)((int)'0' + j);
					int num = Integer.parseInt(String.valueOf(charArray));
					if(num < 1000) continue;
					if(!isPrime[num]) continue;
					if(isvisited[num]) continue;
					q.add(new int[] {num, data[1]+1});
					isvisited[num] = true;
				}
			}
		}
	}	
}
