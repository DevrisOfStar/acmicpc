package Problem_19940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void getAnswer() {
		int[] arr = new int[5];
		int sixties, tens, ones;
		sixties = N / 60;
		tens = (N % 60) / 10;
		ones = N % 10;
		
		if(ones > 5) {
			tens ++;
			ones -= 10;
		}
		if(tens > 3) {
			sixties++;
			tens -= 6;
		}
		if(tens < 0 && ones == 5) {
			tens++;
			ones-=10;
		}
		
		arr[0] = sixties;
		if(tens > 0) arr[1] = Math.abs(tens);
		else arr[2] = Math.abs(tens);
		if(ones > 0) arr[3] = Math.abs(ones);
		else arr[4] = Math.abs(ones);
		String str = "";
		for(int i = 0; i<5;i++) str += (arr[i] + " ");
		sb.append(str.trim()).append("\n");
 	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			getAnswer();
		}
		System.out.println(sb.toString());
	}
}

