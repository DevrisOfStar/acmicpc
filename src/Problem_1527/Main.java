package Problem_1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr = {4,7};
	static long a,b;
	static long cnt = 0;
	public static void find47(long number) {
		if(number > b) return;
		if(number >= a)  {
			cnt++;
		}
		for(int i = 0; i< 2; i++) {
			find47(number * 10 + arr[i]);
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		a = Long.parseLong(str.split(" ")[0]);
		b = Long.parseLong(str.split(" ")[1]);
		find47(0);
		System.out.println(cnt);
	}
}
