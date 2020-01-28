package Problem_13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf;
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] answers = new int[N];
		long answer = 0;
		bf = br.readLine();
		st = new StringTokenizer(bf, " ");
		for(int i = 0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		bf = br.readLine();
		
		int B = Integer.parseInt(bf.split(" ")[0]);
		int C = Integer.parseInt(bf.split(" ")[1]);
		answer +=N;
		for(int i = 0; i<N; i++) arr[i]-= B;
		for(int i = 0; i<N; i++) answers[i] = (int) (arr[i] > 0 ? Math.ceil((double)arr[i]/(double)C):0);
		for(int i = 0; i<N; i++) answer+=answers[i];
		
		System.out.println(answer);
	}
}
