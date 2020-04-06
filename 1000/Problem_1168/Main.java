package Problem_1168;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int K = Integer.parseInt(str.split(" ")[1]);
		StringBuilder sb = new StringBuilder("<");
		int[] arr = new int[N+1];
		
		for(int i = 0; i < N; i++) arr[i] = i+1;
		
		int i = K-1;
		while(N > 0) {
			if(N==1) {
				sb.append(arr[0]).append(">\n");
				break;
			}
			
			sb.append(arr[i]).append(", ");
			for(int j = i; j<N;j++) {
				arr[j] = arr[j+1];
			}
			N--;
			i = (i+K-1) % N;
		}

		System.out.println(sb);

	}
}
