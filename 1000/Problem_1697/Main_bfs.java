package Problem_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*2019-07-29 완료 */

/* N과 K가 같을때의 경우도 고려해야한다. */
class data {
	int location;
	int time;
 
	public data(int location, int time) {
		this.location = location;
		this.time = time;
	}
}
public class Main_bfs {
	static int isvisited[] = new int[100001];
	
	
	public static void bfs(int n, int k) {
	
		Queue<data> q = new LinkedList<data>();
		q.add(new data(n,0));
		
		while(!q.isEmpty()) {
		data d_ = q.poll();
		
		
		if(d_.location - 1 >= 0 && d_.location -1 <= 100000 && isvisited[d_.location-1] == 0) { // 방문 x
			q.add(new data(d_.location-1, d_.time+1));
			isvisited[d_.location-1] = d_.time+1;
		}
		if(d_.location + 1 >= 0 && d_.location + 1 <= 100000 && isvisited[d_.location+1] == 0) { // 방문 x
			q.add(new data(d_.location+1, d_.time+1));
			isvisited[d_.location+1] = d_.time+1;
		}
		if(d_.location * 2 >= 0 && d_.location * 2 <= 100000 && isvisited[d_.location * 2] == 0) { // 방문 x
			q.add(new data(d_.location*2, d_.time+1));
			isvisited[d_.location*2] = d_.time+1;
		}
		
			
		}
			System.out.println(isvisited[k]);
			return;
	}
	
	
	public static void main(String[] args) throws IOException {
		// subin's location : N
		// brother's location : K
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		int N = Integer.parseInt(temp[0]);
		int K = Integer.parseInt(temp[1]);
		if(N == K) { System.out.println("0");}
		else {bfs(N,K);}
	}
}
