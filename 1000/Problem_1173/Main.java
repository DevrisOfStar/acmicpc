package Problem_1173;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf = br.readLine();

		int N = Integer.parseInt(buf.split(" ")[0]);
		int m = Integer.parseInt(buf.split(" ")[1]);
		int M = Integer.parseInt(buf.split(" ")[2]);
		int T = Integer.parseInt(buf.split(" ")[3]);
		int R = Integer.parseInt(buf.split(" ")[4]);

		int time = 0;
		int cur_m = m;
		int ex_time = 0;
		boolean flag = true;
		for (;; time++) {
			if (ex_time == N)
				break;
			if (cur_m + T <= M) { // 운동
				cur_m += T;
				ex_time++;
				flag = true;
			} else if (cur_m - R >= m) { // 휴식, 맥박이 충분한 경우
				cur_m -= R;
			} else if (cur_m - R < m) { // 휴식, 맥박이 부족한 경우
				// 맥박이 부족한 순간을 2번 거치게되면, 운동 불가능
				cur_m = m;
				if (!flag) {
					time = -1;
					break;
				}
				flag = false;
			} else { // 해당되지 않는 경우
				time = -1;
				break;
			}
		}
		System.out.println(time);

	}
}
