package Problem_17269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int[] alpha = {3,2,1,2,4,3,1,3,1,1,3,1,3,2,1,2,2,2,1,2,1,1,1,2,2,1};
	static int[] data;
	static int a,b, idx;
	static String c,d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Queue<Integer> q = new LinkedList<>();
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		idx = 0;
		data = new int[a+b];
		st = new StringTokenizer(br.readLine()," ");
		c = st.nextToken();
		d = st.nextToken();
		if(a > b) {
			for(int i = 0 ; i < b; i++) {
				data[idx++] = alpha[c.charAt(i)-'A'];
				data[idx++] = alpha[d.charAt(i)-'A'];
			}
			
			for(int i = b ; i < a; i++) {
				data[idx++] = alpha[c.charAt(i)-'A'];
			}
		}
		else {
			for(int i = 0 ; i < a; i++) {
				data[idx++] = alpha[c.charAt(i)-'A'];
				data[idx++] = alpha[d.charAt(i)-'A'];
			}
			
			for(int i = a ; i < b; i++) {
				data[idx++] = alpha[d.charAt(i)-'A'];
			}
		}
		
		for(int i = 0 ; i < data.length;i++) {
			q.offer(data[i]);
		}
		
		while(q.size() > 2) {
			int t = q.size();
			int az = q.poll();
			int bz;
			for(int i = 0; i < t-1; i++) {
				bz = q.poll();
				az+=bz;
				az %=10;
				q.offer(az);
				az = bz;
			}
		}
		a = q.poll();
		b = q.poll();
		a = a*10 + b;
		System.out.println(a+"%");
		
	}
}
