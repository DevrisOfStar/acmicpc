package Problem_4811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static long cnt = 0;
	static long[][] arr = new long[31][31];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data;
		do {
			data = br.readLine();
			if(!data.equals("0")) {
				System.out.println(func(Integer.parseInt(data),0));				
			}else {
				break;
				
			}
		} while(true);
	}
	
	public static long func(int data, int ban) {
		if(data < 0) return 0;
		if(data == 0 && ban == 0) return 1;
		if(arr[data][ban] > 0) {
			return arr[data][ban];
		}
		if(data > 0) {
			arr[data][ban] += func(data-1, ban+1);
		}
		if(ban > 0) {
			arr[data][ban] += func(data, ban-1);
		}
		return arr[data][ban];
	}
}
