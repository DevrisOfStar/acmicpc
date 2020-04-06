package Problem_1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int N = Integer.parseInt(str.split(" ")[0]);
		int D = Integer.parseInt(str.split(" ")[1]);
		
		int[][] paths = new int[N][3];
		
		for(int i = 0; i<N;i++) {
			str = br.readLine();
			for(int j = 0; j < 3; j++) {
				paths[i][j] = Integer.parseInt(str.split(" ")[j]);
			}
		}

		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {0, 0});
		int min_drive = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int[] data = q.poll();
			int min_drivepath = Integer.MAX_VALUE;
			int min_idx = -1;
			
			if(data[0] == D) {
				if(min_drive > data[1]) {
					min_drive = data[1];
				}
				continue;
			}
			
			for(int i = 0; i < N; i++) {
				if(data[0] == paths[i][0] && paths[i][1] <= D) {
					q.add(new int[] {paths[i][1], paths[i][2]+data[1]});
					
				}
				
				if(data[0] < paths[i][0] &&  min_drivepath > paths[i][0]) {
					min_drivepath = paths[i][0];
					min_idx = i;
				}
			}
			
			if(min_idx != -1) {
				q.add(new int[] {min_drivepath, min_drivepath-data[0]+data[1]});
			}
			else {
				q.add(new int[] {D, data[1] + D-data[0]});
			}
			
		}
		
		System.out.println(min_drive);
	}
}
