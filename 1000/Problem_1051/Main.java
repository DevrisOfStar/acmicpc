package Problem_1051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		int[][] arr = new int[N][M];
		
		for(int i = 0; i <N; i++) {
			str = br.readLine();
			for(int j = 0; j<M;j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		int K = Math.min(N, M);
		int max_value = 1;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M;j++) {
				for(int k = 1; k<K ;k++) {
					if(i+k >= N || j+k >= M) continue;
					if(arr[i][j] == arr[i][j+k] && arr[i][j] == arr[i+k][j] && arr[i][j] == arr[i+k][j+k]) {
						if(max_value < (k+1)) max_value = (k+1);
					}
				}
			}
		}
		System.out.println(max_value * max_value);
		
	}
}
