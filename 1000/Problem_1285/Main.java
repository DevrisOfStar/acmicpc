package Problem_1285;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] copy_arr = new boolean[N][N];
		boolean[][] arr = new boolean[N][N]; // 동전 상태
		String bf;
		for(int i = 0; i<N; i++) {
			bf = br.readLine();
			for(int j = 0; j <N; j++) {
				char c = bf.charAt(j);
				if(c == 'T') arr[i][j] = true;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i< (1<<N);i++) {
				int cnt = 0;
				for(int r = 0; r<N; r++) {
					for(int c = 0; c<N;c++) {
						copy_arr[r][c] = arr[r][c];
					}
				}
				
				for(int j = 1 ; j <= i; j=j<<1) {
					if((i&j) == j) {						
						// 뒤집기 실행
						int a = (int)(Math.log10(j) / Math.log10(2));
						
						for(int k = 0; k<N; k++) {
							 copy_arr[k][a]^= true;
						}
					}
				}
				
				for(int k = 0; k<N; k++) {
					int temp = 0;
					for(int l = 0; l<N;l++) {
						if(copy_arr[k][l]) temp++;
					}
					
					cnt += (temp > N-temp ? N-temp : temp);
				}
			if(min > cnt) min = cnt;
		}
		
		System.out.println(min);
		
	}
}
