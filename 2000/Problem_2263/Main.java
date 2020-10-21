package Problem_2263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] in_order, post_order, in_index;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		in_order = new int[N+1];
		post_order = new int[N+1];
		in_index = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N <= 100000
		for(int i = 0; i< N; i++) 
			in_order[i] = Integer.parseInt(st.nextToken());
		for(int i =0; i<N; i++) in_index[in_order[i]] = i;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< N; i++)
			post_order[i] = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		solve(0, N-1, 0, N-1, sb);
		System.out.println(sb.toString().trim());
	}
	
	// i_s, i_e : in-order index, p_s, p_e : pre-order index.
	public static void solve(int i_s, int i_e, int p_s, int p_e,
			StringBuilder sb) {
		if(i_s > i_e || p_s > p_e) return;
		
		int root = post_order[p_e];
		sb.append(root).append(" ");
		int p = in_index[root];
		int left = p - i_s;
		
		solve(i_s, p-1,p_s,p_s+left-1,sb);
		solve(p+1, i_e,p_s+left, p_e-1,sb);
		
		
	}
}
