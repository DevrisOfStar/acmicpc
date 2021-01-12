package Problem_17264;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, P;
	static int W, L, G;
	static String[][] Player;
	static boolean isWin(String nick) {
		for(int i =0; i<Player.length;i++) {
			if(Player[i][0].equals(nick)) {
				return Player[i][1].equals("W") ? true : false;
			}
		}
		
		return false;
	}
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf = br.readLine();
		N = Integer.parseInt(buf.split(" ")[0]);
		P = Integer.parseInt(buf.split(" ")[1]);
		
		buf = br.readLine();
		W = Integer.parseInt(buf.split(" ")[0]);
		L = Integer.parseInt(buf.split(" ")[1]);
		G = Integer.parseInt(buf.split(" ")[2]);
		
		Player = new String[P][2];
		
		for(int i = 0; i <P; i++) {
			buf = br.readLine();
			Player[i][0] = buf.split(" ")[0];
			Player[i][1] = buf.split(" ")[1];
		}
		int cnt = 0;
		boolean isIronMan = false;
		for(int i = 0; i<N; i++) {
			String nick = br.readLine();
			if(isWin(nick)) {
				cnt += W;
				if(cnt >= G) {
					isIronMan = true;
					break;
				}
			} else {
				cnt = cnt-L > 0 ? cnt-L : 0; 
			}
		}
		if(isIronMan) System.out.println("I AM NOT IRONMAN!!");
		else System.out.println("I AM IRONMAN!!");
	}
}
