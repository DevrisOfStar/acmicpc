package Problem_1275;

import java.util.Scanner;

public class Main {
	static long[] tree;
	static long[] nums;
	
	static void init(int node, int start, int end) {
		if(start == end) {
			tree[node] = nums[start];
		}
		else {
			int mid = (start + end)/2;
			init(node*2+1, start, mid);
			init(node*2+2, mid+1, end);
			// init data.
			tree[node] = tree[node*2+1] + tree[node*2+2];
		}
	}
	
	static void update(int node, int start, int end, int index, long diff) {
		if(!(start <= index && index <= end)) return;
		
		tree[node] += diff;
		
		if(start != end) {
			int mid = (start + end)/2;
			update(node*2+1, start, mid, index, diff);
			update(node*2+2, mid+1, end, index, diff);
		}
	}
	static long query(int node, int start, int end, int i, int j) {
		if(i > end || j < start) return -1;
		if(i <= start && end <= j) return tree[node];
		
		int mid = (start + end) / 2;
		long m1 = query(node*2+1, start, mid, i,j);
		long m2 = query(node*2+2, mid+1, end, i,j);
		
		if(m1 == -1)
			return m2;
		else if(m2 == -1)
			return m1;
		else
			return m1+m2;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		
		nums = new long[N];
		for(int i = 0; i<N;i++) nums[i] = sc.nextLong();
		
		int treeHeight = (int)Math.ceil(Math.log(N)/Math.log(2));
		int treeSize = (int)Math.pow(2,  treeHeight+1);
		
		tree = new long[treeSize];
		init(0, 0, N-1);
		
		while(Q-->0) {
			// index
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int a = sc.nextInt()-1;
			
			// value 
			long b = sc.nextInt();
			
			if(x>y) {
				int temp = x;
				x = y;
				y= temp;
			}
			
			System.out.println(query(0,0,N-1, x,y));
			update(0, 0, N-1, a,b-nums[a]);
			nums[a] = b;
		}
	}
}
