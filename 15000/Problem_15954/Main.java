package Problem_15954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N,K;
	static int[] arr;
	static double answer = Double.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf = br.readLine();
		N = Integer.parseInt(buf.split(" ")[0]);
		K = Integer.parseInt(buf.split(" ")[1]);
		arr = new int[N];
		buf = br.readLine();
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(buf.split(" ")[i]);
		}
		
		for(int i = 0 ; i<=N-K;i++) {
			int k = K;
			while(i+k <= N) {
				double m = 0.0;
				double t = 0.0;
				for(int j = i; j<i+k;j++) m+=arr[j];
				m/=(double)k;
				for(int j = i; j<i+k;j++) t+=((arr[j]-m)*(arr[j]-m));
				t/=(double)k;
				if(answer > t) answer = t;
				k++;
			}
		}
		System.out.printf("%.11f", Math.sqrt(answer));
	}
}
