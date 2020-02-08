package Problem_5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class data {
	int stair; // 현재 층수
	int cnt; // 버튼 누른 횟수

	public data(int stair, int cnt) {
		this.stair = stair;
		this.cnt = cnt;
	}
}

public class Main {
	public static void bfs(int F, int S, int G, int U, int D) {
		int visited[] = new int[F + 1];

		if (S == G) {
			System.out.println("0");
			return;
		}

		Queue<data> q = new LinkedList<data>();
		q.add(new data(S, 0));
		visited[S] = 0;

		while (!q.isEmpty()) {
			data data_ = q.poll();
 
			if (data_.stair + U <= F && visited[data_.stair + U] == 0) {
				q.add(new data(data_.stair + U, data_.cnt + 1));
				visited[data_.stair+U] = data_.cnt+1;
			}

			if (data_.stair - D >= 0 && visited[data_.stair - D] == 0) {
				q.add(new data(data_.stair - D, data_.cnt + 1));
				visited[data_.stair-D] = data_.cnt+1;
			}
		}

		if (visited[G] > 0) {
			System.out.println(visited[G]);
		} else {
			System.out.println("use the stairs");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int F = Integer.parseInt(temp[0]);
		int S = Integer.parseInt(temp[1]);
		int G = Integer.parseInt(temp[2]);
		int U = Integer.parseInt(temp[3]);
		int D = Integer.parseInt(temp[4]);

		bfs(F, S, G, U, D);
	}
}
