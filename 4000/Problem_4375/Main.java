package Problem_4375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf; 
		while((buf = br.readLine())!= null) {
			int n = Integer.parseInt(buf);
			int k = 0;
			for (int i=1;;i++) {
	        	k = k*10+1;
	        	k = k%n;
	        	if (k==0) {
	        		System.out.println(i);
	        		break;
	        	}
	        }	
		}
		
	}
}
