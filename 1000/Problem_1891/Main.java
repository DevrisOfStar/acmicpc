package Problem_1891;

import java.util.Scanner;

public class Main {
	static int d;
	static String No;
	static long x, y;
	
	static class Data {
		long x, y;

		public Data(long x, long y) {
			this.x = x;
			this.y = y;
		}		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		d = sc.nextInt();
		No = sc.next();
		x = sc.nextLong();
		y = sc.nextLong();
		char[] Nums = String.valueOf(No).toCharArray();
		
		long size = 1L << d;
		Data data = func(Nums, 0, 0, 0, size);
		
		data.x -= y;
		data.y += x;
		
		if(0 <= data.x && size > data.x && 0 <= data.y && size > data.y) {			
			String str = dfunc(0, 0, size, data.x, data.y);
			System.out.println(str);
		}
		else {
			System.out.println("-1");
		}
	}
	
	public static Data func(char[] num, int idx, long x, long y, long size) {
		if(size == 1) return new Data(x, y);
		else {
			switch(num[idx]) {
			case '1':
				return func(num, idx+1, x, y+size/2, size/2);
			case '2':
				return func(num, idx+1, x, y, size/2);
			case '3':
				return func(num, idx+1, x+size/2, y, size/2);
			case '4':
				return func(num, idx+1, x+size/2, y+size/2, size/2);
			}
		}
		return new Data(0l, 0l);
	}
	
	public static String dfunc(long r, long c, long size, long x, long y) {
		if(size == 1) return ""; // 끝
		if(x < r+size/2 && y < c+size/2)  // 2사분면
			return "2" + dfunc(r, c, size/2, x, y);
		else if(x < r+size/2 && y >= c+size/2)  // 1사분면
			return "1" + dfunc(r, c+size/2, size/2, x, y);
		else if(x >= r+size/2 && y < c + size/2)  // 3사분면
			return "3" + dfunc(r+size/2, c, size/2, x,y);
		else  // 4사분면
			return "4" +dfunc(r+size/2, c+size/2, size/2, x,y);
		
	}
}
