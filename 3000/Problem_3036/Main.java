package Problem_3036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		for(int i = 0; i <N; i++) arr[i] = Integer.parseInt(st.nextToken());
			
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<N;i++) {
			int a = ans(arr[0],arr[i]);
			sb.append(arr[0]/a+ "/"+ arr[i]/a).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int ans(int a, int b) {
		int c, d; 
		if ( a < b) { c = b; d = a;}
		else {c = a; d = b;}
		
		if(c%d == 0) return d;
		return ans(d, c%d);
	}
}
 
