package Problem_14241;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		
		for(;st.hasMoreTokens();) pq.add(Integer.parseInt(st.nextToken()));
		int score = 0;
		while(pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			score += (a*b);
			pq.add(a+b);
		}
		
		System.out.println(score);
	}
}
