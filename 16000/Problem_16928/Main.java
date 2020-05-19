package Problem_16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] map = new int[101];
	static boolean[] isvisited = new boolean[101];

	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { 1, 0 });
		isvisited[1] = true;

		while (!q.isEmpty()) {
			int[] data = q.poll();
			if (data[0] == 100) {
				System.out.println(data[1]);
				System.exit(0);
			}
			for (int i = 1; i <= 6; i++) {
				int d = data[0] + i;
				if (d > 100)
					continue;
				if (isvisited[d])
					continue;
				q.add(new int[] { map[d], data[1] + 1 });
				isvisited[d] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int a = Integer.parseInt(str.split(" ")[0]);
		int b = Integer.parseInt(str.split(" ")[1]);
		int c = a + b;

		for (int i = 1; i <= 100; i++)
			map[i] = i;
		for (int i = 0; i < c; i++) {
			str = br.readLine();
			a = Integer.parseInt(str.split(" ")[0]);
			b = Integer.parseInt(str.split(" ")[1]);
			map[a] = b;
		}

		bfs();

	}
}
