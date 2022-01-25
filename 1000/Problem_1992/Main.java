package Problem_1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str);
		arr = new int[N][N];
		for(int i = 0; i<N; i++) {
			str = br.readLine();
			for(int j = 0; j<N;j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		System.out.println(getTree(0, 0, N));
	}
	
	static String getTree(int starti, int startj, int size) {
		String data = "";
		int d = arr[starti][startj];
		boolean flag = true;
		for(int i = starti; i<starti+size;i++) {
			for(int j = startj; j<startj+size;j++) {
				if(arr[i][j] != d) {
					flag = false;
					break;
				}
			}
		}
		
		if(flag) {
			return String.valueOf(d);
		}
		else {
			StringBuilder sb = new StringBuilder();
			sb.append("(");
			sb.append(getTree(starti, startj, size/2));
			sb.append(getTree(starti, startj + size/2, size/2));
			sb.append(getTree(starti + size/2, startj, size/2));
			sb.append(getTree(starti+size/2, startj + size/2, size/2));
			sb.append(")");
			return sb.toString();
		}
	}
}
