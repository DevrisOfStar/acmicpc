package Problem_18511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N,K;
	static int t;
	static int[] arr;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf = br.readLine();
		N = Integer.parseInt(buf.split(" ")[0]);
		K = Integer.parseInt(buf.split(" ")[1]);
		arr = new int[K];
		buf = br.readLine();
		for(int i = 0; i<K;i++) {
			arr[i] = Integer.parseInt(buf.split(" ")[i]);
		}
		t = String.valueOf(N).length();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0 ; i<K;i++) q.add(arr[i]);
		
		while(!q.isEmpty()) {
			int data = q.poll();
			if(max < data) max = data;

			for(int i = 0; i<K;i++) {
				if(data*10 +arr[i] <= N)
				q.add(data*10 + arr[i]);
			}	
		}
		System.out.println(max);
	}
}
