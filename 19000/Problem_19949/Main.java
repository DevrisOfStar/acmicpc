package Problem_19949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr = new int[10];
	static int[] ans = new int[10];
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<10;i++) ans[i] = Integer.parseInt(st.nextToken());
		answer(0, 0);
		System.out.println(cnt);
	}
	
	static void answer(int idx, int jumsu) {
		if(idx == 10) {
			if(jumsu >= 5)cnt++;
		}
		else if(idx == 1 || idx == 0){
			for(int i = 1 ; i<=5 ; i++) {
				arr[idx] = i;
				answer(idx+1, arr[idx] == ans[idx] ? jumsu+1: jumsu);
				arr[idx] = 0;
			}
		}
		else {
			for(int i = 1 ; i<=5 ; i++) {
				if(arr[idx-1] == i && arr[idx-2] == i) continue;
				arr[idx] = i;
				answer(idx+1, arr[idx] == ans[idx] ? jumsu+1: jumsu);
				arr[idx] = 0;
			}
		}
		
	}
}
