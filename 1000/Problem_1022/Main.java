package Problem_1022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int r1, c1, r2, c2;
	static int[][] arr;
	static void answer() {
 		int x = 0, y = 0, dir = 0;
		int num = 1, dnum = 1, cnt = 0;
		int a = 0;
		while(arr[0][0] == 0 || arr[r2-r1][0] == 0 || arr[0][c2-c1] == 0 || arr[r2-r1][c2-c1] == 0) {
			if(x>=r1 && x<=r2 && y>=c1 && y<=c2) {
				arr[x-r1][y-c1] = num;
				a++;
				
			}
			x = x+dx[dir];
			y = y+dy[dir];
			num++;
			cnt++;
			
			if(cnt == dnum) {
				cnt = 0;
				if(dir == 1 ||dir == 3) dnum++;
				dir = (dir+1)%4;
				
			}
		}
		int maxLen = (int)Math.log10(num - 1), len;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <= r2-r1; i++) {
			for(int j = 0 ; j<= c2-c1; j++) {
				len = maxLen - (int)Math.log10(arr[i][j]);
				for(int k = 0; k<len;k++) {
						sb.append(" ");
				}
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		r1 = Integer.parseInt(str.split(" ")[0]);
		c1 = Integer.parseInt(str.split(" ")[1]);
		r2 = Integer.parseInt(str.split(" ")[2]);
		c2 = Integer.parseInt(str.split(" ")[3]);
		
		arr = new int[r2-r1+1][c2-c1+1];
		answer();
	}
}
