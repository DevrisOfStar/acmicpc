package Problem_14247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long ans = 0;
		ArrayList<int[]> arr = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			arr.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st2.nextToken()) });

		Collections.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[1] > o2[1] ? 1 : -1;
			}
		});

		for (int i = 0; i < N; i++) {
			ans = ans + arr.get(i)[0]+ arr.get(i)[1] * i;
		}

		System.out.println(ans);
	}
}
