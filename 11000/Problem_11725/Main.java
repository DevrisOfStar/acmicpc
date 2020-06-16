package Problem_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String temp;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int[] parents = new int[N + 1];
		for(int i = 0; i <=N+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			temp = br.readLine();
			int a = Integer.parseInt(temp.split(" ")[0]);
			int b = Integer.parseInt(temp.split(" ")[1]);
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(1);
		parents[1] = 1;
		
		while(!q.isEmpty()) {
			int parent = q.poll();
			
			for(int item : list.get(parent)) {
				if(parents[item] == 0) {
					parents[item] = parent;
					q.offer(item);
				}
			}
		}
		
		for(int i = 2; i<=N; i++) {
			System.out.println(parents[i]);
		}

	}
}
