package Problem_1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	static class data implements Comparable<data>{
		int m, v;

		public data(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public String toString() {
			return "data [m=" + m + ", v=" + v + "]";
		}

		@Override
		public int compareTo(data o) {
			// TODO Auto-generated method stub
			return this.m - o.m;
		}

		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf = br.readLine();
		int N = Integer.parseInt(bf.split(" ")[0]);
		int K = Integer.parseInt(bf.split(" ")[1]);
		data[] jlist = new data[N];
		int[] sacklist = new int[K];
		for(int i = 0; i < N;i++) {
			bf = br.readLine();
			jlist[i] = new data(Integer.parseInt(bf.split(" ")[0]),Integer.parseInt(bf.split(" ")[1]));
		}
		for(int i = 0; i<K; i++) {
			sacklist[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(jlist);
		Arrays.sort(sacklist);

		PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> Integer.compare(y, x));
		long cnt = 0;
		int idx = 0;
		for(int i =0; i < sacklist.length; i++) {
			while(idx < jlist.length && jlist[idx].m <= sacklist[i]) {
				pq.add(jlist[idx++].v);				
			}
			
			if(!pq.isEmpty()) cnt+= pq.poll();
		}
		
		System.out.println(cnt);
		
	}
}
