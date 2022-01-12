package Problem_2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		int[] Links = new int[N+1];
		
		ArrayList<ArrayList<Integer>> data = new ArrayList<>();
		for (int i = 0; i<N+1; i++) data.add(new ArrayList<Integer>());
		for (int i = 0; i<M; i++) {
			str = br.readLine();
			int a,b;
			a = Integer.parseInt(str.split(" ")[0]);
			b = Integer.parseInt(str.split(" ")[1]);
			data.get(a).add(b);
			Links[b]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i<=N;i++) {
			if(Links[i] == 0) q.add(i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N;i++) {
			int t = q.poll();
			sb.append(t).append(" ");
			
			for(int nextT : data.get(t)) {
				Links[nextT]--;
				if(Links[nextT] == 0) {
					q.add(nextT);
				}
			}
		}
		System.out.println(sb.toString());
	}
}
