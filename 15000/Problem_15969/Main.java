package Problem_15969;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int max = 0;
		int min = 1001;
		int num;
		for(int i = 0 ; i < t; i++) {
			num = Integer.parseInt(st.nextToken());
			if(max < num) max = num;
			if(min > num) min = num;
		}
		
		System.out.println(max-min);
		
		
	}
}
