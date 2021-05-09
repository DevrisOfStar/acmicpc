package Problem_2757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf, temp;
		StringBuilder sb = new StringBuilder();
		int a, b, c, d;
		while(true) {
			buf = br.readLine();
			temp = "";
			a = buf.indexOf("R");
			b = buf.indexOf("C");
			c = Integer.parseInt(buf.substring(a+1,b));
			d = Integer.parseInt(buf.substring(b+1,buf.length()));
			if(c == 0 && d == 0) {
				System.out.println(sb.toString());
				return;
			}
			d--;
			while (d >= 26) {
				temp += ((char)('A' + d%26));
				d/=26;
				d-=1;
			}
			temp += ((char)('A' + d));
			temp = new StringBuilder(temp).reverse().toString();
			sb.append(temp).append(c).append("\n");
		}
		
	}
}
