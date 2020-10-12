package Problem_2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] arr;
	static long[] tree;
	static long init(int start, int end, int node) {
		if(start == end) return tree[node] = arr[start];
		int mid = (start+end)/2;
		
		return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	
	static long sum(int start, int end, int node, int left, int right) {
		if(left > end || right < start) return 0; // 범위 밖에 있는 경우
		if(left <= start && end <= right) return tree[node]; // 범위 안에 있는 경우
		// 그렇지 않으면 두부분으로 나누어 합 구하기
		
		int mid = (start+end) / 2;
		return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left,right);
		
	}
	
	static void update(int start, int end, int node, int index, long dif) {
		if(index<start || index > end) return; // 범위 밖
		
		// 범위 안이면 업데이트
		tree[node] += dif;
		if(start == end) return;
		int mid = (start + end) / 2;
		update(start, mid, node*2, index, dif);
		update(mid+1, end, node*2+1, index, dif);
	}
	static int N,M,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf = br.readLine();
		N = Integer.parseInt(bf.split(" ")[0]);
		M = Integer.parseInt(bf.split(" ")[1]);
		K = Integer.parseInt(bf.split(" ")[2]);
		
		
		arr = new long[N];
		tree = new long[arr.length * 4];
		
		for(int i = 0; i<arr.length;i++) arr[i] = Long.parseLong(br.readLine());
		
		init(0, arr.length-1,1);
		M +=K;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i <M; i++) {
			bf = br.readLine();
			if(Integer.parseInt(bf.split(" ")[0]) == 1) { // update
				long diff = Long.parseLong(bf.split(" ")[2]) - arr[Integer.parseInt(bf.split(" ")[1])-1];
				arr[Integer.parseInt(bf.split(" ")[1])-1] = Long.parseLong(bf.split(" ")[2]);
				update(0, N-1, 1, Integer.parseInt(bf.split(" ")[1])-1, diff);
			}
			else { // print sum
				sb.append(sum(0, N-1, 1, Integer.parseInt(bf.split(" ")[1])-1, Integer.parseInt(bf.split(" ")[2])-1)).append("\n");
			}			
		}
		
		System.out.println(sb.toString());
		
		
	}
}
