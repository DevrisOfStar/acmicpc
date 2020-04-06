package Problem_17615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		
		int r_cnt = 0;
		int b_cnt = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i<arr.length;i++)
			if(arr[i] =='R') r_cnt++;
			else b_cnt++;
		
		int idx = 0;
		int cnt = 0;
		
		while(idx < N && arr[idx++]=='R')cnt++;
		min = min > r_cnt - cnt ? r_cnt-cnt : min;
		
		idx = N-1; cnt = 0;
		while(idx >= 0 && arr[idx--]=='R')cnt++;
		min = min > r_cnt - cnt ? r_cnt-cnt : min;
		
		idx = 0; cnt = 0;
		while(idx < N && arr[idx++]=='B')cnt++;
		min = min > b_cnt - cnt ? b_cnt-cnt : min;
		
		idx = N-1; cnt = 0;
		while(idx >= 0 && arr[idx--]=='B')cnt++;
		min = min > b_cnt - cnt ? b_cnt-cnt : min;

		System.out.println(min);
	}
}
