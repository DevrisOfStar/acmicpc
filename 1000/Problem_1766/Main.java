package Problem_1766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		
		int[] lines = new int[N+1];
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		
		for(int i = 0; i<= N; i++) arr.add(new ArrayList<Integer>());
		
		for(int i = 0; i<M; i++) {
			str = br.readLine();
			int a = Integer.parseInt(str.split(" ")[0]);
			int b = Integer.parseInt(str.split(" ")[1]);
			arr.get(a).add(b);
			lines[b]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i =1; i<=N; i++) { if(lines[i] == 0) q.add(i); }
		
		while(!q.isEmpty()) {
			int data = q.poll();
			sb.append(data).append(" ");
			for(int next : arr.get(data)) {
				lines[next]--;
				
				if(lines[next] == 0) {
					q.add(next);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
