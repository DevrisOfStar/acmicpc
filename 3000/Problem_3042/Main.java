package Problem_3042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[26][2];
		int cnt = 0;
		int N = Integer.parseInt(br.readLine());
		String buf;
		for(int i = 0; i<N; i++) {
			buf = br.readLine();
			for(int j = 0; j <N; j++) {
				char tem = buf.charAt(j);
				if(tem =='.') continue;
				arr[cnt][0] = i;
				arr[cnt++][1] = j;
			}
		}
		int answer = 0;
		for(int i = 0; i<cnt; i++) {
			for(int j = i; j<cnt; j++) {
				if(i == j) continue;
				for(int k = j; k<cnt; k++) {
					if(j == k || i== k) continue;
					// 여기서 판별
					int a = arr[i][0], b = arr[i][1];
					int c = arr[j][0], d = arr[j][1];
					int e = arr[k][0], f = arr[k][1];
					
					int x1 = c-a; int y1 = d-b;
					int x2 = e-c; int y2 = f-d;
					
					if(x1 == 0 && x2 == 0) answer++;
					else if(y1 == 0 && y2 == 0) answer++;
					else {
						if(x1 == 0) continue;
						if(x2 == 0) continue;
						if(y1*x2 == y2*x1) answer++;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
