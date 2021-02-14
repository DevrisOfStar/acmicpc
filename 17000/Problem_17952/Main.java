package Problem_17952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Subject {
		int score;
		int minutes;
		
		public Subject(int score, int minutes) {
			this.score = score;
			this.minutes = minutes;
		}
		
		public void DoThis() {
			if(minutes > 0)	minutes--;
		}
	}
	
	static class hakgi {
		Subject current;
		Stack<Subject> stack = new Stack<Subject>();
		int sum_score;
		
		public void getSubject(int score, int minutes) {
			Subject sb = new Subject(score, minutes);
			if(current != null) stack.add(current);
			current = sb;
			doSubject();
		}
		
		public void doSubject() {
			if(current!=null) {
				current.DoThis();
				if(current.minutes == 0) {
					sum_score += current.score;
					if(!stack.isEmpty()) current = stack.pop();
					else current = null;
				}	
			}
		}
		
		public void printSumScore() {
			System.out.println(sum_score);
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		hakgi hg = new hakgi();
		String buf;
		StringTokenizer st = null;
		for(int i = 0; i <N; i++) {
			buf = br.readLine();
			if(buf.equals("0")) { 
				hg.doSubject();
			} else {
				st = new StringTokenizer(buf);
				st.nextToken();
				hg.getSubject(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
		}
		hg.printSumScore();
		
	}
}
