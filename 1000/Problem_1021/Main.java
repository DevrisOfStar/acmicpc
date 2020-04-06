package Problem_1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> q = new ArrayList<>();
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[0]);
		str = br.readLine();
		String[] ars = str.split(" ");
		int[] data = new int[ars.length];

		for (int i = 0; i < ars.length; i++) data[i] = Integer.parseInt(ars[i]);
		for (int i = 1; i <= N; i++) q.add(i);
		int r,l;
		int cnt =0;
		for(int i = 0; i< data.length;i++) {
			l = leftside(q, data[i]);
			r = rightside(q, data[i]);
			
			if(l > r) { // right
				cnt += rightPop(q, data[i]);
			} else { // left
				cnt += leftPop(q, data[i]);
			}
		}
		
		System.out.println(cnt);
		
	}
	public static int leftPop(ArrayList<Integer> q, int number) {
		int cnt = 0;
		boolean bool = false;
		
		while(!bool) {
			if(q.get(0) == number) {
				q.remove(0);
				bool = true;
			} 
			else {
				q.add(q.get(0));
				q.remove(0);
				cnt++;
			}
		}
		return cnt;
	}
	public static int rightPop(ArrayList<Integer> q, int number) {
		int cnt = 0;
		boolean bool = false;
		
		while(!bool) {
			if(q.get(0) == number) {
				q.remove(0);
				bool = true;
			} 
			else {
				q.add(0,q.get(q.size()-1));
				q.remove(q.size()-1);
				cnt++;
			}
		}
		return cnt;
	}
	public static int leftside(ArrayList<Integer> q, int number) {
		for(int i = 0; i<q.size();i++) {
			if(q.get(i) == number) {
				return i;
			}
		}
		return -1;
	}
	
	public static int rightside(ArrayList<Integer> q, int number) {
		for(int i = 0; i<q.size();i++) {
			if(q.get(i) == number) {
				return q.size()-i;
			}
		}
		return -1;
	}
}
