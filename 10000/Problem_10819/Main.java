package Problem_10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] arr;
	static int[] order;
	static boolean[] isvisited;
	static int answer = Integer.MIN_VALUE;
	static int cnt = 0;
	public static void getAnswer(int idx) {
		if(idx == N) {
			int num = 0;
			for(int i = 0; i<N-1; i++)
				num += Math.abs(arr[order[i]] - arr[order[i+1]]);
			if(answer < num) answer = num;
		}
		else {
			for(int i = 0; i<N; i++) {
				if(!isvisited[i]) {
					isvisited[i] = true;
					order[idx] = i;
					getAnswer(idx+1);
					order[idx] = -1;
					isvisited[i] = false;
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		order = new int[N];
		isvisited = new boolean[N];
		String str = br.readLine();
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(str.split(" ")[i]);
		getAnswer(0);
		System.out.println(answer);
	}
}
