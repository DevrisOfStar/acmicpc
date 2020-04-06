package Problem_2884;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int hour = Integer.parseInt(str.split(" ")[0]);
		int minute = Integer.parseInt(str.split(" ")[1]);
		
		if(minute >= 45) minute-=45;
		else if(hour>=1){
			hour--;
			minute+=15;
		}
		else {
			hour = 23;
			minute+=15;
		}
		System.out.println(hour + " " + minute);
		
	}
}
