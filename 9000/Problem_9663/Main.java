package Problem_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] map;
	static int N, cnt;
	
	static void NQueen(int idx) {
		if(idx == N) {
			cnt++;
		}
		else {
			for(int i = 0; i < N; i++) {
				map[idx] = i;
				if(isPromising(idx)) NQueen(idx+1);
			}
			
		}
	}
	
	static boolean isPromising(int idx) {
		for(int i = 0; i < idx;i++) {
			if(map[idx] == map[i]) return false;
			if((map[i] - map[idx]) == (i-idx)) return false;
			if((map[i] - map[idx]) == (idx-i)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		Arrays.fill(map, -1);
		
		NQueen(0);
		
		
		System.out.println(cnt);
		
		
		
	}
}
