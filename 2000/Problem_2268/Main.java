package Problem_2268;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, M;
	static long[] arr;
	static long[] tree;
	
	static long query(int start, int end, int node, int left, int right) {
		if(left > end || right < start) return 0;
		if(left <= start && end <= right) return tree[node];
		
		int mid = (start+end)/2;
		return query(start, mid, node*2, left, right) + query(mid+1, end, node*2+1, left,right);		
	}
	
	static void update(int start, int end, int node, int index, long dif) {
		if(index < start || index > end) return;
		tree[node]+= dif;
		if(start==end) return;
		int mid = (start+end)/2;
		update(start, mid, node*2, index, dif);
		update(mid+1, end, node*2+1, index, dif);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf = br.readLine();
		N = Integer.parseInt(buf.split(" ")[0]);
		M = Integer.parseInt(buf.split(" ")[1]);
		arr = new long[N+1];
		tree = new long[arr.length*4+4];
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<M; i++) {
			buf = br.readLine();
			int a = Integer.parseInt(buf.split(" ")[1]);
			int b = Integer.parseInt(buf.split(" ")[2]);
			if(buf.split(" ")[0].equals("0")) { // sum result
				if(a > b) { // i,j no condition. so, always do i<j to swap.
					int temp = a;
					a = b;
					b = temp;
				}
				sb.append(query(1,N,1,a,b)).append("\n");
			} else { // update : modify
				long dif = (long)b-arr[a];
				arr[a] = b;
				update(1,N,1,a,dif);
			}
		}
		System.out.println(sb.toString());
	}
}
