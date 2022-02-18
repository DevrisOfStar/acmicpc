package Problem_10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<ArrayList<String>> arr = new ArrayList<>();
		for(int i = 0; i<= 200; i++) arr.add(new ArrayList<String>());
		int N = Integer.parseInt(br.readLine());
		String tmp;
		
		for(int i = 0; i<N; i++) {
			tmp = br.readLine();
			arr.get(Integer.parseInt(tmp.split(" ")[0])).add(tmp.split(" ")[1]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<=200;i++) {
			ArrayList<String> s = arr.get(i);
			for(int j = 0 ; j<s.size();j++) sb.append(i).append(" ").append(s.get(j)).append("\n");
		}
		System.out.print(sb.toString());
	}
}
