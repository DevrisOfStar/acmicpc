package Problem_3019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int c = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int answer = 0;
		st = new StringTokenizer(br.readLine(), " ");
		int[] map = new int[c];

		for (int i = 0; i < c; i++)
			map[i] = Integer.parseInt(st.nextToken());

		switch (p) {
		case 1:
			answer += c;
			for (int i = 0; i < c - 3; i++) {
				if (map[i] == map[i + 1] && map[i + 1] == map[i + 2] && map[i + 2] == map[i + 3])
					answer++;
			}
			break;
		case 2:
			for (int i = 0; i < c - 1; i++) {
				if (map[i] == map[i + 1]) {
					answer++;
				}
			}
			break;
		case 3:
			for (int i = 0; i < c - 2; i++) {
				if (map[i] == map[i + 1] && map[i + 1] == map[i + 2] - 1) {
					answer++;
				}
			}
			for (int i = 0; i < c - 1; i++) {
				if (map[i] == map[i + 1] + 1) {
					answer++;
				}
			}

			break;
		case 4:
			for (int i = 0; i < c - 2; i++) {
				if (map[i] - 1 == map[i + 1] && map[i + 1] == map[i + 2]) {
					answer++;
				}
			}
			for (int i = 0; i < c - 1; i++) {
				if (map[i] + 1 == map[i + 1]) {
					answer++;
				}
			}
			break;
		case 5:
			for (int i = 0; i < c - 1; i++) {
				if (map[i] == map[i + 1] + 1) {
					answer++;
				}
			}
			for (int i = 0; i < c - 1; i++) {
				if (map[i] + 1 == map[i + 1]) {
					answer++;
				}
			}

			for (int i = 0; i < c - 2; i++) {
				if (map[i] == map[i + 1] && map[i + 1] == map[i + 2])
					answer++;
			}
			
			for(int i = 0 ; i < c- 2; i++) {
				if ( map[i] == map[i+1]+1 && map[i+1]+1 == map[i+2])
					answer++;
			}
			break;
		case 6:
			for (int i = 0; i < c - 2; i++) {
				if (map[i] == map[i + 1] && map[i + 1] == map[i + 2])
					answer++;
			}
			for (int i = 0; i < c - 1; i++) {
				if (map[i] == map[i + 1]) {
					answer++;
				}
			}
			for (int i = 0; i < c - 1; i++) {
				if (map[i] - 2 == map[i + 1])
					answer++;
			}

			for (int i = 0; i < c - 2; i++) {
				if (map[i] + 1 == map[i + 1] && map[i + 1] == map[i + 2])
					answer++;
			}
			break;
		case 7:
			for (int i = 0; i < c - 2; i++) {
				if (map[i] == map[i + 1] && map[i + 1] == map[i + 2])
					answer++;
			}
			for (int i = 0; i < c - 1; i++) {
				if (map[i] == map[i + 1]) {
					answer++;
				}
			}
			for (int i = 0; i < c - 1; i++) {
				if (map[i] == map[i + 1] -2)
					answer++;
			}

			for (int i = 0; i < c - 2; i++) {
				if (map[i] == map[i + 1] && map[i + 1] == map[i + 2]+1)
					answer++;
			}

			break;
		default:
			break;
		}

		System.out.println(answer);
	}
}
