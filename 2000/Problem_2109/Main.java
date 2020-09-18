package Problem_2109;

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
		int p, d;

		public data(int p, int d) {
			this.p = p;
			this.d = d;
		}

		@Override
		public int compareTo(data o) {
			if(this.d > o.d ) return -1;
			if(this.d < o.d ) return 1;
			
			return this.p < o.p ? 1 : -1;
		}		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf = br.readLine();
		int N = Integer.parseInt(bf);
		data[] arr = new data[N];
		
		
		for(int i = 0; i <N; i++) {
			bf = br.readLine();
			arr[i] = new data(Integer.parseInt(bf.split(" ")[0]),Integer.parseInt(bf.split(" ")[1]));
		}
		Arrays.sort(arr);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int cnt = 0;
		int uniIdx = 0;
		for(int i = 10000 ; i >= 1; i--) {
			while(uniIdx < N && i <= arr[uniIdx].d) {
				pq.add(arr[uniIdx++].p);
			}
			
			if(!pq.isEmpty()) cnt += pq.poll();
		}
		
		System.out.println(cnt);
	}
}
