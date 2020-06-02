package Problem_15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[] isSelected;
	static ArrayList<int[]> house_list = new ArrayList<>();
	static ArrayList<int[]> chick_list = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	
	public static void solution(int idx, int cnt) {
		if(cnt == M) {
			int distance = 0;
			
			for(int i = 0; i < house_list.size();i++) {
				int[] house = house_list.get(i);
				int[] chick;
	
				int min_dis = Integer.MAX_VALUE;
				for(int j = 0; j < chick_list.size();j++) {
					if(isSelected[j]) {
						chick = chick_list.get(j);
						int data = Math.abs(chick[0]-house[0]) + Math.abs(chick[1]-house[1]);
						if(min_dis > data) {
							min_dis = data;
						}
					}
				}
				distance += min_dis;
			}
			
			if(min > distance) min = distance;
				
		}
		else {
			for(int i = idx; i < chick_list.size(); i++) {
				if(!isSelected[i]) {
					isSelected[i] = true;
					solution(i, cnt+1);
					isSelected[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);
		arr = new int[N][N];
		
		for(int i = 0; i<N;i++) {
			str = br.readLine();
			for(int j = 0; j<N;j++) {
				arr[i][j] = Integer.parseInt(str.split(" ")[j]);
				if(arr[i][j] == 1) house_list.add(new int[] {i,j});
				else if(arr[i][j] == 2) chick_list.add(new int[] {i,j});
			}
		}
		isSelected = new boolean[chick_list.size()];
		solution(0,0);
		System.out.println(min);
		
	}
}
