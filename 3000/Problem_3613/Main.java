package Problem_3613;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		boolean flag = false;
		boolean error = false;
		boolean isUsed = false;
		boolean isUnder = false;
		boolean isUpper = false;
		int i = 0;
		for(i = 0; i<str.length();i++) {
			if(str.charAt(i)=='_') {
				isUsed = true;
				if(isUpper || flag || i == str.length()-1 || i == 0) {
					error = true; 
					break;
				}
				flag = true;
			}
			else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				flag = false;
			} else {
				isUpper = true;
				if(isUsed) {
					error = true;
					break;	
				}
			}
		} // 판별
		
		if(i == str.length() && isUsed) isUnder = true;
		if(str.charAt(0) >= 'A' && str.charAt(0) <= 'Z') error = true;
		StringBuilder sb = new StringBuilder();
		
		// 변환
		if(error) System.out.println("Error!");
		else if(isUnder){
			for(i = 0; i<str.length();i++) {
				char c = str.charAt(i);
				if(c == '_') {
					flag = true;
					continue;
				}
				if(flag) {
					flag = false;
					c = (char)(c + 'A' - 'a');
				}
				sb.append(c);
			}
			System.out.println(sb.toString());
		}
		else {
			for(i = 0; i< str.length() ;i++) {
				char c = str.charAt(i);
				if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')  {
						c = (char)(c - 'A' + 'a');
						sb.append('_');
					}
				sb.append(c);
			}			
			System.out.println(sb.toString());
		}
	}
}
