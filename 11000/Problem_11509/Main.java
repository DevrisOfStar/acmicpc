package Problem_11509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int cnt = 0;
		int[] arrow = new int[1000002];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arrow[arr[i] + 1] == 0) {
				arrow[arr[i]]++;
				cnt++;
			} else {
				arrow[arr[i] + 1]--;
				arrow[arr[i]]++;
			}
		}

		System.out.println(cnt);

	}
}
