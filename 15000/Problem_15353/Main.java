package Problem_15353;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// 언어 제한 : C / C++
	// Java로 문제만 풀었음, 채점하지 않음.
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf = br.readLine();
		
		StringBuilder a = new StringBuilder(buf.split(" ")[0]);
		StringBuilder b = new StringBuilder(buf.split(" ")[1]);
		a.reverse();
		b.reverse();
		String a_ = a.toString();
		String b_ = b.toString();
		StringBuilder c = new StringBuilder();
		
		boolean isTen = false;
		int length = a_.length() > b_.length() ? a_.length() : b_.length();
		for(int i = 0; i<length; i++) {
			int a__ = 0;
			int b__ = 0;			
			if(i < a_.length()) a__ = a_.charAt(i) - '0';
			if(i < b_.length()) b__ = b_.charAt(i) - '0';
			
			int c__ = a__ + b__;
			if(isTen) {
				c__ += 1;
				isTen = false;
			}
			if(c__/10 == 1) isTen = true;
			c__%=10;
			
			c.append(c__);
		}
		if(isTen) c.append(1);
		System.out.println(c.reverse());
	}
}
