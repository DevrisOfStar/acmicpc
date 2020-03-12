package Problem_2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);

		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int s, e;
		s = 0;
		e = 0;
		int ans = 2000000001;
		while (s!=N && e!=N) {
			if (arr[e] - arr[s] < M) {
				e++;
			} else {
				if(ans > arr[e] - arr[s]) ans = arr[e] - arr[s];
				s++;
			}
			
		}

		System.out.println(ans);
	}
}
