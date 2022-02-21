package Problem_1058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		String s;
		for(int i = 0; i<N; i++) {
			s = br.readLine();
			for(int j = 0; j<N; j++) {
				arr[i][j] = s.charAt(j) == 'Y' ? 1 : 0;
				if(arr[i][j] == 0 && i!=j) arr[i][j] = 1000000;
			}
		}

		for(int i = 0; i<N; i++) {
			for(int k = 0; k<N; k++) {
				for(int j = 0; j<N; j++) {
					if(i==j || j==k || i==k) continue;
					if(arr[i][j] + arr[j][k] < arr[i][k]) {
						arr[i][k] = arr[i][j] + arr[j][k];  						
					}
				}
			}
		}
		int max = 0;
		for(int i = 0; i<N; i++) {
			int cnt = 0;
			for(int j = 0; j<N; j++) {
				if(i==j) continue;
				if(arr[i][j] <= 2) cnt++;
			}
			if(cnt > max) max = cnt;
		}
		System.out.println(max);
	}
}
