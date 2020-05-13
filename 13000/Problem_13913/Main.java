package Problem_13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class data {
	int time;
	int space;
	public data(int time, int space) {
		super();
		this.time = time;
		this.space = space;
	}

}
public class Main {
	static int n, k;
	static boolean[] isvisited = new boolean[100001];
	static int[] parent = new int[100001];
	public static void bfs(int n, int k) {
		Queue<data> q = new LinkedList<>();
		q.add(new data(0,n));
		isvisited[n] = true;
		
		while(!q.isEmpty()) {
			data d = q.poll();
			
			if(d.space == k) {
				// 여기가 시간을 줄이는 관건
				System.out.println(d.time);
				ArrayList<Integer> list = new ArrayList<>();
				StringBuilder sb = new StringBuilder();
				int idx = d.space;
				while(idx != n) {
					list.add(idx);
					idx = parent[idx];
				}
				list.add(n);
				
				for(int i = list.size()-1; i>=0;i--) {
					sb.append(list.get(i)).append(" ");
				}
				
				System.out.println(sb.toString().trim());
				return;
			}
			else {
				if(d.space-1 >= 0 && !isvisited[d.space-1]) {
					q.add(new data(d.time+1, d.space-1));
					isvisited[d.space-1] = true;
					parent[d.space-1] = d.space;
				
				}
				if(d.space+1 <= 100000 && !isvisited[d.space+1]) {
					q.add(new data(d.time+1, d.space+1));
					isvisited[d.space+1] = true;			
					parent[d.space+1] = d.space;
				}
				if(d.space*2 <= 100000 && !isvisited[d.space*2]) {
					q.add(new data(d.time+1, d.space*2));
					isvisited[d.space*2] = true;
					parent[d.space*2] = d.space;
				}
			}
			
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf = br.readLine();
		n = Integer.parseInt(bf.split(" ")[0]);
		k = Integer.parseInt(bf.split(" ")[1]);
		
		bfs(n,k);
	}
}
