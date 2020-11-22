package Problem_14438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] data;
	static int[] tree;
	static int N;
	
	static int init(int node, int start, int end) {
		if(start == end) {
			return tree[node] = data[start]; 
		}
		int mid = (start + end)/2;
		return tree[node] = Math.min(init(node*2, start, mid), init(node*2+1, mid+1, end));
	}
	
	static int getVal(int node, int left, int right, int start, int end) {
		if(left > end || right < start) return Integer.MAX_VALUE;
		if(left <= start && end <= right) return tree[node];
		int mid = (start + end) / 2;
		return Math.min(getVal(node*2, left, right, start, mid), getVal(node*2+1, left, right, mid+1, end));
	}
	
	static int update(int node, int start, int end, int index, int val) {
		if(index < start || index > end) return tree[node];
		if(start == end) return tree[node] = val;
		int mid = (start+end)/2;
		return tree[node] = Math.min(update(node*2, start, mid, index, val),
				update(node*2+1, mid+1, end, index, val));
	}
	
	static int getVal(int left, int right) {
		return getVal(1, left, right, 1, N);
	}
	
	static void update(int index, int val) {
		data[index] = val;
		update(1, 1, N, index, val);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		data = new int[N+1];
		
		int treeHeight = (int)Math.ceil(Math.log(N)/Math.log(2));
		int treeSize = (int)Math.pow(2,  treeHeight+1);
		tree = new int[treeSize];
		Arrays.fill(tree, Integer.MAX_VALUE);
		
		for(int i =1;i<=N;i++) data[i] = Integer.parseInt(st.nextToken());
		init(1, 1, N);
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int method = Integer.parseInt(st.nextToken());
			int param1 = Integer.parseInt(st.nextToken());
			int param2 = Integer.parseInt(st.nextToken());
			sb.append(Query(method, param1, param2));
		}
		
		System.out.println(sb.toString());
	}
	
	static String Query(int method, int par1, int par2) {
		if(method == 1) {
			update(par1, par2);
			return "";
		} else {
			return String.valueOf(getVal(par1,par2)) + "\n";
		}
	}
}
