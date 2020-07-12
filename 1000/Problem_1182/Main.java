package Problem_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, S;
	static int cnt;
	static int[] arr;
	static boolean[] isSelected;
	
	public static void ans(int idx) {
		if(idx == N) {
			int sum = 0;
			for(int i = 0; i <N; i++) {
				if(isSelected[i])
					sum+=arr[i];
			}
			if(sum==S) cnt++;
		}
		else {
			isSelected[idx] =true;
			ans(idx+1);
			isSelected[idx] =false;
			ans(idx+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		
		N = Integer.parseInt(buffer.split(" ")[0]);
		S = Integer.parseInt(buffer.split(" ")[1]);
		
		arr = new int[N];
		isSelected = new boolean[N];
		
		buffer = br.readLine();
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(buffer.split(" ")[i]);
		}
		ans(0);
		if(S == 0) cnt--;
		System.out.println(cnt);
	}
}
