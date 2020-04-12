package Problem_15997;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class data {
	String a;
	String b;
	double w, d, l;
	public data(String a, String b, double w, double d, double l) {
		this.a = a;
		this.b = b;
		this.w = w;
		this.d = d;
		this.l = l;
	}

}
public class Main {

	
	static ArrayList<String> team = new ArrayList<>();
	static int[] score = new int[4];
	static double[] answer = new double[4];
	static data[] dt_ = new data[6]; 
	static void answer(int n, double p) {
		if(n == 6) {
			ArrayList<int[]> arr = new ArrayList<>();
			for(int i = 0; i<4;i++) {
				arr.add(new int[] {i, score[i]});
			}
			arr.sort(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] > o2[1]) return 1;
					else return -1;
				}
			});
		
			if(arr.get(1)[1] != arr.get(2)[1]) { // 1,2,3등을 정할 수 있는 경우
				answer[arr.get(2)[0]] += p;
				answer[arr.get(3)[0]] += p;
			}
			else if(arr.get(0)[1] == arr.get(1)[1] && arr.get(2)[1] == arr.get(3)[1]) { // 4명이 모두 똑같은 경우
				answer[arr.get(0)[0]] += p/2.0;
				answer[arr.get(1)[0]] += p/2.0;
				answer[arr.get(2)[0]] += p/2.0;
				answer[arr.get(3)[0]] += p/2.0;
			} else if(arr.get(0)[1] == arr.get(1)[1]) { // 3명이 똑같은 경우, 2,3,4등
				answer[arr.get(0)[0]] += p/3.0;
				answer[arr.get(1)[0]] += p/3.0;
				answer[arr.get(2)[0]] += p/3.0;
				answer[arr.get(3)[0]] += p;
			} else if(arr.get(2)[1] == arr.get(3)[1]) { // 3명이 똑같은 경우, 1,2,3등
				answer[arr.get(1)[0]] += p*2.0/3.0;
				answer[arr.get(2)[0]] += p*2.0/3.0;
				answer[arr.get(3)[0]] += p*2.0/3.0;
			} else { // 공동 2등인 경우
				answer[arr.get(1)[0]] += p/2.0;
				answer[arr.get(2)[0]] += p/2.0;
				answer[arr.get(3)[0]] += p;
			}
		}
		else {
			int x_ = team.indexOf(dt_[n].a);
			int y_ = team.indexOf(dt_[n].b);
			score[x_] += 3;
			answer(n+1, p*dt_[n].w);
			score[x_] -= 3;
			
			score[x_] += 1;
			score[y_] += 1;
			answer(n+1, p*dt_[n].d);
			score[x_] -= 1;
			score[y_] -= 1;
			
			score[y_] += 3;
			answer(n+1, p*dt_[n].l);
			score[y_] -= 3;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		for(int i = 0; i<temp.length;i++) team.add(temp[i]);
		for(int i = 0; i<6; i++) {
			temp = br.readLine().split(" ");
			dt_[i] = new data(temp[0],temp[1], Double.parseDouble(temp[2]),Double.parseDouble(temp[3]),Double.parseDouble(temp[4]));
		}
		answer(0, 1.0);
		for(int i = 0; i < answer.length;i++) {
			System.out.printf("%.10f\n", answer[i]);
		}
	}
}
