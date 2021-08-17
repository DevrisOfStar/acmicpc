package Problem_1393;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long xs,ys; // station
	static long xt,yt; // train 
	static long dx,dy; // velocity
	static long d_t; // gcd
	static long x_, y_; // temp_x, temp_y
	static long near_x = Integer.MAX_VALUE, near_y = Integer.MAX_VALUE;
	static long gcd(long a, long b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String bf = br.readLine();
		xs = Long.parseLong(bf.split(" ")[0]);
		ys = Long.parseLong(bf.split(" ")[1]);
		
		bf = br.readLine();
		xt = Long.parseLong(bf.split(" ")[0]);
		yt = Long.parseLong(bf.split(" ")[1]);
		dx = Long.parseLong(bf.split(" ")[2]);
		dy = Long.parseLong(bf.split(" ")[3]);
		
		d_t = Math.abs(dx) > Math.abs(dy) ? 
				gcd(Math.abs(dx), Math.abs(dy)) :
					gcd(Math.abs(dy), Math.abs(dx));
		if(d_t != 0) { dx/= d_t; dy/= d_t; }
		
		for(long i = 0; i<=100; i++) {
			x_ = xt + i*dx;
			y_ = yt + i*dy;
			
			if(isNear(x_,y_)) {
				near_x = x_; near_y = y_;
			}
		}
		System.out.println(near_x + " " + near_y);
	}
	
	static boolean isNear(long x_, long y_) {
		long a = (x_ - xs) * (x_ - xs) + (y_ - ys) * (y_ - ys);
		long b = (near_x - xs) * (near_x - xs) + (near_y - ys) * (near_y - ys);
		return a < b;
	}
}
