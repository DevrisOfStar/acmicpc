package Problem_16206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 == 10) return 1;
				if(o2 == 10) return -1;
				if(o1 % 10 == 0 && o2 % 10 == 0) return o1-o2;
				if(o1 % 10 == 0) return -1;
				if(o2 % 10 == 0) return 1;
				else return o2-o1;
			}
		});
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);

		str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		while(st.hasMoreTokens()) pq.add(Integer.parseInt(st.nextToken()));

		while(M-- > 0) {
			int num = pq.poll();
			if(num % 10 == 0 && num!=10) {
				pq.add(num-10);
				pq.add(10);
			}
			else {
				if(num <= 10) pq.add(num);
				else {
					pq.add(num-10);
					pq.add(10);
				}
			}
		}
		int cnt = 0;
		while(!pq.isEmpty()) cnt += (pq.poll() == 10 ? 1 : 0);
		System.out.println(cnt);
	}
}
