package Problem_1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int a = 0, b = 0;
		int temp, temp2 = 0;
		int[][] arr = new int[N+1][2]; // arr[1] = 0;
		for(int i = 2; i <=N;i++) {
			if(i%2 == 0) {
				temp = i;
				temp2 = 0;
				for( ;temp % 2 == 0 ; ) {
					temp2++;
					temp/=2;
				}
				arr[i][0] = arr[i-1][0] + temp2;
				if(a < arr[i][0]) a = arr[i][0];
			}else {
				arr[i][0] = a;
			}
			if(i%5 == 0) {
				temp = i;
				temp2 = 0;
				for( ;temp % 5 == 0 ; ) {
					temp2++;
					temp/=5;
				}
				arr[i][1] = arr[i-1][1] + temp2;
				if(b < arr[i][1]) b = arr[i][1];
			}
			else {
				arr[i][1] = b;
			}
		}
		
		
		System.out.println(Math.min(arr[N][0], arr[N][1]));
		
	}
}
