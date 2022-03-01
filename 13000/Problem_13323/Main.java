package Problem_13323;

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
		long num;
		PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long answer = 0;
		for(int i = 0; i<N; i++) {
			num = Long.parseLong(st.nextToken());
			num-=i; // b1 < b2 < ... <bn
			pq.add(num);
			
			if(!pq.isEmpty() && pq.peek() > num) {
				answer += (pq.peek() - num);
				pq.poll();
				pq.add(num);
			}
		}
		System.out.println(answer);
	}
}
