package Problem_2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		int sum = 0;
		int[] arr = new int[N];
		str = br.readLine();
		for(int i = 0; i<N; i++)  arr[i] = Integer.parseInt(str.split(" ")[i]);
		int tmp;
		for(int i = 0; i<N; i++) {
			for(int j = i+1; j<N; j++) {
				for(int k = j+1; k<N; k++) {
					tmp = arr[i] + arr[j] + arr[k];
					if(tmp <= M && sum < tmp) sum = tmp;
				}
			}
		}
		System.out.println(sum);
	}
}
