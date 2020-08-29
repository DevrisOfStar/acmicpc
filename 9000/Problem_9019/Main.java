package Problem_9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static boolean[] isvisited = new boolean[10000];
	public static String answer(int a, int b) {
		String answer = "";
		
		Queue<String[]> q = new LinkedList<>();
		isvisited[a] = true; 
		q.add(new String[] {String.valueOf(a), ""});
		
		while(!q.isEmpty()) {
			String[] datas = q.poll();
			
			int data = Integer.parseInt(datas[0]);
			if(data == b) {
				answer = datas[1];
				return answer;
			}
			
			int d = (data * 2) % 10000;
			int s = (data + 9999) % 10000;
			int l = ((data%1000)/100)*1000 + ((data%100)/10)*100 + (data%10)*10+(data/1000);
			int r = (data%10) * 1000 + (data/1000) * 100 +  ((data%1000)/100) * 10 + ((data%100)/10);
			
			if(!isvisited[d]) {
				q.add(new String[] {String.valueOf(d), datas[1] + "D"});
				isvisited[d] = true;
			}
			
			if(!isvisited[s]) {
				q.add(new String[] {String.valueOf(s), datas[1] + "S"});
				isvisited[s] = true;
			}
			
			if(!isvisited[l]) {
				q.add(new String[] {String.valueOf(l), datas[1] + "L"});
				isvisited[l] = true;
			}
			
			if(!isvisited[r]) {
				q.add(new String[] {String.valueOf(r), datas[1] + "R"});
				isvisited[r] = true;
			}
			
			
		}
		
		return answer;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String bf;
		
		for(int t = 1 ; t<=T; t++) {
			bf = br.readLine();
			int a = Integer.parseInt(bf.split(" ")[0]);
			int b = Integer.parseInt(bf.split(" ")[1]);
			
			System.out.println(answer(a,b));
			Arrays.fill(isvisited, false);
		}
		
		
	}
}
