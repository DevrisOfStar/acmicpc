package Problem_15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N,M;
	static int[] arr;
	static boolean[] arr_;
	public static void ans(int a, int cnt) {
		if(cnt == M) {
			for(int i = 0; i < N; i++)
				if(arr_[i])System.out.print(arr[i] + " ");
			System.out.println();
		}
		else {
			for(int i = a; i<N; i++) {
				if(!arr_[i]) {
					arr_[i] = true;
					ans(i, cnt+1);
					arr_[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		N = Integer.parseInt(buffer.split(" ")[0]);
		M = Integer.parseInt(buffer.split(" ")[1]);
		arr = new int[N];
		for(int i = 0 ; i < arr.length; i++) arr[i] = i+1;
		arr_ = new boolean[N];
		ans(0, 0);
		
	}
}
