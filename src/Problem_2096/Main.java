package Problem_2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[2][3];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d,e,f;
		for(int i = 0 ; i < 2; i ++) {
			arr[i][0] = a; arr[i][1] = b; arr[i][2] = c;
		}
		for(int i = 0 ; i<N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Math.max(arr[0][0] + a, arr[0][1] + a);
			e = Math.max(Math.max(arr[0][0] + b, arr[0][1] + b), arr[0][2] + b);
			f = Math.max(arr[0][2] + c, arr[0][1] + c);
			arr[0][0] = d; arr[0][1] = e; arr[0][2] = f;
			
			d = Math.min(arr[1][0] + a, arr[1][1] + a);
			e = Math.min(Math.min(arr[1][0] + b, arr[1][1] + b), arr[1][2] + b);
			f = Math.min(arr[1][2] + c, arr[1][1] + c);
			
			arr[1][0] = d; arr[1][1] = e; arr[1][2] = f;
		}
		int max = Math.max(Math.max(arr[0][0], arr[0][1]),arr[0][2]);
		int min = Math.min(Math.min(arr[1][0], arr[1][1]),arr[1][2]);
		System.out.println(max + " " + min);
	}
}
