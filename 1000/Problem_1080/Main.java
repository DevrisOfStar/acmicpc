package Problem_1080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int m,n;
	static boolean[][] arr, arr2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf = br.readLine();
		
		m = Integer.parseInt(bf.split(" ")[0]);
		n = Integer.parseInt(bf.split(" ")[1]);
		arr = new boolean[m][n];
		arr2 = new boolean[m][n];
		
		for(int i = 0; i <m; i++) {
			bf = br.readLine();
			for(int j = 0; j <n; j++) {
				if(bf.charAt(j) == '1') {
					arr[i][j] = true;
				}
			}
		}
		for(int i = 0; i <m; i++) {
			bf = br.readLine();
			for(int j = 0; j <n; j++) {
				if(bf.charAt(j) == '1') {
					arr2[i][j] = true;
				}
			}
		}
		int cnt = 0;
		
		for(int i = 0; i <m-2; i++) {
			for(int j = 0; j<n-2; j++) {
				if(arr[i][j] != arr2[i][j]) {
					cnt++;
					for(int k = 0; k<3; k++) {
						for(int l = 0; l <3; l++) {
							arr[i+k][j+l] ^= true;
						}
					}
				}
			}
		}
		for(int i = 0; i <m; i++) {
			for(int j = 0; j <n; j++) {
				if(arr[i][j] != arr2[i][j]) {
					System.out.println("-1");
					return;
				}
			}
		}
		System.out.println(cnt);
	}
}
