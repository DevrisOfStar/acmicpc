package Problem_1085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int x = Integer.parseInt(str.split(" ")[0]);
		int y = Integer.parseInt(str.split(" ")[1]);
		int w = Integer.parseInt(str.split(" ")[2]);
		int h = Integer.parseInt(str.split(" ")[3]);
		int min = Integer.MAX_VALUE;
		if(x<min) min=x;
		if(y<min) min=y;
		if(w-x<min) min=w-x;
		if(h-y<min) min=h-y;
		
		System.out.println(min);
		
	}
}
