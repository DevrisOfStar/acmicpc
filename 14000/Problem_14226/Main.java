package Problem_14226;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int s;
	static boolean[][] isvisited = new boolean[1001][1001];

	public static void bfs() {

		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { 1, 0, 0 });
		isvisited[1][0] = true;

		while (!q.isEmpty()) {
			int[] data = q.poll();
			if (data[0] == s) {
				System.out.println(data[2]);
				System.exit(0);
			}
			if (!isvisited[data[0]][data[0]]) {
				q.add(new int[] { data[0], data[0], data[2] + 1 });
				isvisited[data[0]][data[0]] = true;
			}
			if (data[0] + data[1] <= 1000 && !isvisited[data[0] + data[1]][data[1]]) {
				q.add(new int[] { data[0] + data[1], data[1], data[2] + 1 });
				isvisited[data[0] + data[1]][data[1]] = true;
			}
			if (data[0] - 1 >= 0 && !isvisited[data[0] - 1][data[1]]) {
				q.add(new int[] { data[0] - 1,data[1], data[2] + 1 });
				isvisited[data[0] - 1][data[1]] = true;
			}

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();

		bfs();
	}
}
