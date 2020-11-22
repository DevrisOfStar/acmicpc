package Problem_10868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf = br.readLine();
		N = Integer.parseInt(bf.split(" ")[0]);
		int M = Integer.parseInt(bf.split(" ")[1]);
		
		arr = new int[N+1];
		int treeHeight = (int)Math.ceil(Math.log(N)/Math.log(2));
		int treeSize = (int)Math.pow(2,  treeHeight+1);
		
		tree = new int[treeSize];
		Arrays.fill(tree, Integer.MAX_VALUE);
		
		for(int i =1;i<=N;i++) arr[i] = Integer.parseInt(br.readLine());
		init(1, 1, N);
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int t = 0; t<M;t++) {
			st = new StringTokenizer(br.readLine());
			int param1 = Integer.parseInt(st.nextToken());
			int param2 = Integer.parseInt(st.nextToken());
			sb.append(Query(param1, param2)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static int init(int node, int start, int end) {
		if(start == end) return tree[node] = arr[start];
		int mid = (start + end)/2;
		return tree[node] = Math.min(init(node*2, start, mid), init(node*2+1, mid+1, end));
	}
	
	static int Query(int left, int right) {
		return getVal(1, left,right, 1, N);
	}
	
	static int getVal(int node, int left, int right, int start, int end) {
		if(left > end || right < start) return Integer.MAX_VALUE;
		if(left <= start && end <= right) return tree[node];
		int mid = (start + end)/2;
		return Math.min(getVal(node*2, left, right, start, mid), getVal(node*2+1, left, right, mid+1, end));
	}
}
