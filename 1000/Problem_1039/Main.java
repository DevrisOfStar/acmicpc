package Problem_1039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		boolean[][] isvisited = new boolean[11][1000001];
		int N = Integer.parseInt(str.split(" ")[0]);
		int K = Integer.parseInt(str.split(" ")[1]);
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {N, 0});
		int max = -1;
		while(!q.isEmpty()) {
			int[] data = q.poll();
			
			
			if(data[1] == K) {
				if(max < data[0]) max = data[0];
				continue;
			}
			char[] temp_digits = String.valueOf(data[0]).toCharArray();
			char[] digits = String.valueOf(data[0]).toCharArray();
			
			for(int i = 0; i<digits.length; i++) {
				for(int j = i; j<digits.length;j++) {
					
					if(i==j) continue;
					if(i == 0 && digits[j] == '0') continue;
					
					char temp = digits[i];
					digits[i] = digits[j];
					digits[j] = temp;
					if(isvisited[data[1]+1][Integer.parseInt(String.valueOf(digits))]) {
						for(int k = 0; k < digits.length;k++) digits[k] = temp_digits[k];
						continue;
					}
					q.add(new int[]{Integer.parseInt(String.valueOf(digits)), data[1]+1});
					isvisited[data[1]+1][Integer.parseInt(String.valueOf(digits))] = true;
					for(int k = 0; k < digits.length;k++) digits[k] = temp_digits[k];
				}
			}
		}
		
		System.out.println(max);
	}
}
