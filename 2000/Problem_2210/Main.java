package Problem_2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] arr = new int[5][5];
	static Set<Integer> ans = new HashSet<>();
	public static void func(int i, int j, int cnt, int data) {
		if(cnt == 6) {
			ans.add(data); // 중복되는 데이터는 add되지 않음.
		}
		else {
			for(int k = 0 ; k < 4; k++) { // 4방향으로 재귀 사용
				int dx_ = i + dx[k];
				int dy_ = j + dy[k];
				if(0> dx_ || 0> dy_ || dx_ >=5 || dy_ >=5) continue;
				func(dx_, dy_, cnt+1, data*10+arr[dx_][dy_]);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		for(int i = 0; i < 5; i++) {
			str = br.readLine();
			for(int j = 0 ; j < 5; j++) {
				arr[i][j] = str.charAt(j*2) -'0';
			}
		}
		
		for(int i = 0 ; i < 5; i++) {
			for(int j = 0 ; j < 5; j++) {
				func(i,j, 1,arr[i][j]);
			}
		}
		System.out.println(ans.size());
		
		
	}
}
