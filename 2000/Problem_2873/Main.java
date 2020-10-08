package Problem_2873;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf = br.readLine();
		StringTokenizer st;
		
		R = Integer.parseInt(bf.split(" ")[0]);
		C = Integer.parseInt(bf.split(" ")[1]);		
		map = new int[R][C];
		
		for(int i = 0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringBuilder sb = new StringBuilder();
		if(R%2 == 1) {
			for(int i = 0; i<R;i++) {
				char c;
				if(i%2 == 0) c = 'R';
				else c = 'L';
				for(int j = 0; j<C-1;j++) {
					sb.append(c);
				}
				if(i != R-1) sb.append("D");
			}
		}
		else if(C%2 == 1) {
			for(int j = 0; j<C;j++) {
				char c;
				if(j%2 ==0) c = 'D';
				else c = 'U';
				for(int i = 0; i<R-1;i++) {
					sb.append(c);
				}
				if(j != C-1) sb.append("R");
			}
		}
		else {
			int r = 0, c = 1;
			
			for(int i = 0; i <R; i++) {
				for(int j = 0; j <C; j++) {
					if((i+j)%2 == 1) {
						if(map[r][c] > map[i][j]) {
							r = i;
							c = j;
						}							
					}
				}
			}
			
			StringBuilder sb2 = new StringBuilder(); // reverse.
			
			int x1 = 0;
			int y1 = 0;
			int x2 = R-1;
			int y2 = C-1;
			
			while(x2 - x1 > 1) { // 2줄씩 없애기
				if(x1/2 < r/2) {
					for(int i = 0; i<C-1;i++)sb.append('R');
					sb.append('D');
					for(int i = 0; i<C-1;i++)sb.append('L');
					sb.append('D');
					x1 += 2;
				}
				
				if(r/2 < x2/2) {
					for(int i = 0; i<C-1;i++)sb2.append('R');
					sb2.append('D');
					for(int i = 0; i<C-1;i++)sb2.append('L');
					sb2.append('D');
					x2 -= 2;
				}
			}
			
			while(y2 - y1 > 1) { // 2줄씩 없애기
				if(y1/2 < c/2) {
					sb.append('D').append('R').append('U').append('R');
					y1 += 2;
				}
				
				if(c/2 < y2/2) {
					sb2.append('D').append('R').append('U').append('R');
					y2 -=2;
				}
			}
			
			if(c == y1) {
				sb.append('R').append('D');
			} else {
				sb.append('D').append('R');				
			}
			
			sb.append(sb2.reverse());
		}
		
		System.out.println(sb);
		
	}
}
